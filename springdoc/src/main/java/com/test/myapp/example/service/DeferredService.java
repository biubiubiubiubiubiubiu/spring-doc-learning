package com.test.myapp.example.service;

import org.springframework.stereotype.Service;



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
