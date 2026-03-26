package javaMultithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _4CachedExecutorService {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=1;i<=100;i++){
            service.execute(new Task3(i));
        }
    }
}

class Task3 implements Runnable {
    private final int taskId;

    public Task3(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run(){
        if(this.taskId==50){
            try{
                Thread.sleep(6000);
            } catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
        }
        System.out.println("Task: "+taskId+" executed by "+Thread.currentThread().getName());
    }
}
