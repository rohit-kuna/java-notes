package javaMultithreading.synchronization;

public class ThreadWithSyncMethod {

    private static int count=0;

    private static synchronized void increment(){
        count++;
    }

    private static synchronized void decrement(){
        count--;
    }

    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            for(int i=0;i<=1000;i++){
                increment();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<=1000;i++){
                decrement();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("count: " + count);
    }
}
