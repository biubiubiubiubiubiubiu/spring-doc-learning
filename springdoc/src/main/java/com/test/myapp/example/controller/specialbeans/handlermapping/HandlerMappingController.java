package com.test.myapp.example.controller.specialbeans.handlermapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Usage: 测试 handler mapping 的有效性
 * @author: srfan
 * Date: 10/26/18 4:11 PM
 */
@Controller
public class HandlerMappingController {

    @RequestMapping(value="/handler-mapping.do", method = RequestMethod.GET)
    public String helloWorld() {
        return "handler_mapping_hello";
    }

    @RequestMapping(value="/custom-exception.do", method = RequestMethod.GET)
    public String throwException() {
        throw new MyCustomException("oh, you got custom exception message~!");
    }

    @RequestMapping(value="/argument-exception.do", method = RequestMethod.GET)
    public String throwArgumentException() {
        throw new IllegalArgumentException("oh, you got argument exception message~!");
    }
}
