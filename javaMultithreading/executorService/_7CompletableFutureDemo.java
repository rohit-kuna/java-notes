package javaMultithreading.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletableFuture;

public class _7CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // with return value
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->3); // supplyAsync(Supplier<U> supplier)

        // just execute async
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(()->{ // runAsync(Runnable runnable)
            System.out.println("execute completefuture2");
        });

        // consuming
        CompletableFuture<Void> completableFuture3 = CompletableFuture.supplyAsync(()->3).thenAccept(System.out::println); // thenAccept(Consumer<? super T> action)

        // transform
        CompletableFuture<Void> completableFuture4 = CompletableFuture.supplyAsync(()->3).thenApply(m->m*m).thenAccept(System.out::println);

        // thenApply vs thenApplyAsync
        // thenApply : the same thread which executed previous step continues
        // thenApplyAsync : different thread is used

        // thenRun -> continue run
        CompletableFuture<Void> completableFuture5 = CompletableFuture.supplyAsync(()->5).thenRun(()->System.out.println("Running"));

        // thenCombining
        CompletableFuture<Integer> completableFuture6 = CompletableFuture.supplyAsync(()->4);
        CompletableFuture<Integer> completableFuture7 = CompletableFuture.supplyAsync(()->8);
        CompletableFuture<Integer> combinedCompletableFuture = completableFuture6.thenCombine(completableFuture7, (a,b)->a+b);
        System.out.println(combinedCompletableFuture.join());

        // get result from CompletableFuture
        // join() -> old, throws Checked exception
        // get() -> new, throws Runtime exception
        // both are blocking
        // non-blocking alternative is thenAccept()
        try {
            int res1 = CompletableFuture.supplyAsync(()->3/0).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // int res2 = CompletableFuture.supplyAsync(()->3/0).join(); // raises runtime exception

        // Using exception handling
        // exceptionally -> used to provide fallback in case of exception
        CompletableFuture
            .supplyAsync(()->3/0)
            .exceptionally((ex)->{
                System.out.println(ex.getMessage());
                return -1;})
            .thenAccept(System.out::println); // can use join() and print the result later

        // handle -> tell what to do in case of both success and exception case, like promise in js
        // you can transform the res
        CompletableFuture
            .supplyAsync(()->3/0)
            .handle((res,ex)->{
                if(ex!=null){return -1;}
                return 2*res;
            })
            .thenAccept(System.out::println);

        // whenComplete -> like handle but not change res or ex, just log
        CompletableFuture
            .supplyAsync(()->3/0)
            .whenComplete((res,ex)->{
                if(ex!=null){
                    System.out.println(ex.getMessage());
                }
            })
            .thenAccept(System.out::println);


    }
}
