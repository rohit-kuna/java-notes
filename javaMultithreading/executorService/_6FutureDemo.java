package javaMultithreading.executorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;

public class _6FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future = executorService.submit(new CallableTask1()); // callable is passed

        try {
            int result0 = future.get(1000, TimeUnit.MILLISECONDS); // throws tiemout exception
            System.out.println(result0); // won't get printed as await time is less
        } catch (InterruptedException ie) {

        } catch (ExecutionException ex) {

        } catch (TimeoutException to){

        }

        try {
            // await for specific time instead of blocking util we get result

            int result = future.get(); // blocking as result appears after 2 seconds
            System.out.println(result); // will appear as waited

        } catch (InterruptedException ie) {

        } catch (ExecutionException ex) {

        }

        // states

        if(future.isDone()){
            System.out.println("future Done");
        } else if(future.isCancelled()){
            System.out.println("future Cancelled");
        }



        // Runnable
        Future<?> future2 = executorService.submit(new RunnableTask1());

        // Runnable + Data
        Future<String> future3 = executorService.submit(new RunnableTask1(),"Done");
        try{
            System.out.println("future3: "+ future3.get());
        } catch(Exception e){

        }

        executorService.shutdown(); // otherwise will stay running
    }
}

class CallableTask1 implements Callable<Integer>{

    public Integer call() throws InterruptedException { // can add throws clause on call method as Future can handle Exception, otherwise need to enclose in try catch
        Thread.sleep(1000);
        return 10;
    }

}

class RunnableTask1 implements Runnable {
    public void run() { // cannot add throws clause on run()
        try{
            Thread.sleep(1000);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        System.out.println("Runnable Task1 Executed by : "+Thread.currentThread().getName());
    }
}
