package com.test.myapp.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExampleController {

    @RequestMapping(value="/hello.do", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello";
    }
}
