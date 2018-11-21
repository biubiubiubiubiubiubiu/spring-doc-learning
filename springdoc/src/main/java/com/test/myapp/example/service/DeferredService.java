package com.test.myapp.example.service;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class DeferredService extends TaskService{

    @Override
    public String execute() {
        try {
            Thread.sleep(5000);
            System.out.println("task finished!");
            return "hello";
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
    }

}
