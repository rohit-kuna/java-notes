package javaMultithreading.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _5CallableSubmitDemo {
    public static void main(String[] args) {
        CallableTask callableTask=new CallableTask();
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer> future = service.submit(callableTask);

        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }

    }
}

class CallableTask implements Callable<Integer> {
    @Override
    public Integer call(){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }

        return 1;
    }
}
