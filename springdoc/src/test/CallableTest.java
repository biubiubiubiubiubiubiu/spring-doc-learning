import org.junit.Assert;
import org.junit.Test;

import util.IntegerTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTest {

    @Test
    public void testCallable() {

        IntegerTask integerTask = new IntegerTask(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> futureTask = executorService.submit(integerTask);
        try {
            Assert.assertEquals(futureTask.get(5, TimeUnit.SECONDS).intValue(), 120);
        } catch (Exception ex) {

        }
    }
}
