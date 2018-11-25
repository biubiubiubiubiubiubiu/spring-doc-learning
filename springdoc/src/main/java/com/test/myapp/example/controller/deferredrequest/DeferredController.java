package com.test.myapp.example.controller.deferredrequest;

import com.test.myapp.example.service.DeferredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

@Controller
public class DeferredController {
    @Autowired
    DeferredService deferredService;

    @RequestMapping(value = "blocking-request.do", method = RequestMethod.GET)
    public String blockingService() {
        System.out.println("start blocking-request...");
        String result = deferredService.execute();
        System.out.println("result retrieved!");
        return result;
    }

    @RequestMapping(value = "non-blocking-request.do", method = RequestMethod.GET)
    public Callable<String> nonBlockingService() {
        System.out.println("start non-blocking-request...");

        Callable<String> result = deferredService::execute;
        System.out.println("result retrieved!");
        return result;
    }

    @RequestMapping(value = "deffered-result.do", method = RequestMethod.GET)
    public DeferredResult<String> deferredResultService() {
        System.out.println("start deferredResult request...");
        DeferredResult<String> result = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            System.out.println("start deferred result handling");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
            }
            System.out.println("finished deferred result handling");
            result.setResult("hello");
        });
        System.out.println("request finished!");
        return result;
    }


}
