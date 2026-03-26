package javaMultithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _1ExecuteDemo {
    public static void main(String[] args) {
        // use .execute() -> when yu don't expect a return value just start and forget
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<=10;i++){
            executorService.execute(()->{
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(ie);
                }
                System.out.println("executed by "+Thread.currentThread().getName());
            });
        }
        executorService.shutdown(); // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. Invocation has no additional effect if already shut down.

        // executorService.shutdownNow(); // Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
    }
}
