package util;

import java.security.InvalidParameterException;
import java.util.concurrent.Callable;

public class IntegerTask implements Callable<Integer> {

    int number;

    public IntegerTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws InvalidParameterException {
        int ret = 1;
        for (int i = 1; i <= number; i++) {
            ret *= i;
        }
        return ret;
    }
}
