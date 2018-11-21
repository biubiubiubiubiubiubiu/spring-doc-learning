package com.test.myapp.example.controller.specialbeans.exceptionresolver;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyExceptionController extends BaseExceptionResolver {

    @RequestMapping("exception-for-annotation.do")
    public void exceptionForAnnotation() {
        throw new CustomExceptionForAnnotation("Oooops, you get CustomExceptionForAnnotation message");
    }
}
