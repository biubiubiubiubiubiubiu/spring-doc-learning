package com.test.myapp.example.controller.specialbeans.exceptionresolver;

public class CustomExceptionForAnnotation extends RuntimeException {

    public CustomExceptionForAnnotation(String msg) {
        super(msg);
    }

}

