package com.test.myapp.example.util;

import java.util.concurrent.Callable;

public interface SlowTaskCallable extends Callable<String> {
    @Override
    String call() throws Exception;
}
