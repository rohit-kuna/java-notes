package javaMultithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService service=Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            service.execute(new Task(i));
        }
    }
}

class Task implements Runnable {
    private int id;
    public Task(int id){
        this.id=id;
    }
    @Override
    public void run(){
        System.out.printf("The task with id : %d is executed by thread %s",this.id, Thread.currentThread().getName());
        System.out.println();
    }
}

