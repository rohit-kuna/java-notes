package javaMultithreading.synchronization;

public class ThreadWithSyncBlock {

    private static int count=0;

    private static void increment(){
        count++;
    }

    private static void decrement(){
        count--;
    }

    private static Object LOCK = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<=1000;i++){
                synchronized(LOCK){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<=1000;i++){
                synchronized(LOCK){
                    decrement();
                }
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
