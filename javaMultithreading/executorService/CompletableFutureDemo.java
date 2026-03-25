package javaMultithreading.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
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

        // join(), get()

    }
}
