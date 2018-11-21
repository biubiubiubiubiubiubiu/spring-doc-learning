package com.test.myapp.example.controller.specialbeans.handlermapping;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof MyCustomException) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("msg", e.getMessage());
            return modelAndView;
        }
        return null;
    }
}
