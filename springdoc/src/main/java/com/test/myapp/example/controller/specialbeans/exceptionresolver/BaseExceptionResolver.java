package com.test.myapp.example.controller.specialbeans.exceptionresolver;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseExceptionResolver {

    @ExceptionHandler({CustomExceptionForAnnotation.class})
    public ModelAndView handleCustomException(CustomExceptionForAnnotation ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("msg", ex.getMessage());
        return modelAndView;
    }

}
