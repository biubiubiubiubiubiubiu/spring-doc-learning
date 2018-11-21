package com.test.myapp.example.controller.deferredrequest;

import com.test.myapp.example.service.DeferredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.Callable;

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
        System.out.println("start blocking-request...");

        Callable<String> result = deferredService::execute;
        System.out.println("result retrieved!");
        return result;
    }


}
