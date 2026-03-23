package javaMultithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args){
        ExecutorService service=Executors.newFixedThreadPool(3);
        for(int i=0;i<=10;i++){
            service.execute(new Task2(i));
        }
    }
}

class Task2 implements Runnable {
    private int id;
    public Task2(int id){
        this.id=id;
    }
    @Override
    public void run(){
        System.out.println("The task with id "+this.id+" is executed by thread "+Thread.currentThread().getName());
    }
}

