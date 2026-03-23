package javaMultithreading.synchronization;

public class SynchronizationMethodLevelBlockingIssueResolution {
    private static Integer count1=0;
    private static Integer count2=0;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            for(int i=1;i<=10000;i++){
                increment1();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=1;i<=10000;i++){
                increment2();
            }
        });

        Thread t3 = new Thread(()->{
            for(int i=1;i<=10000;i++){
                decrement1();
            }
        });

        Thread t4 = new Thread(()->{
            for(int i=1;i<=10000;i++){
                decrement2();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            // TO-DO
        }

        System.out.println("count1: " + count1 + ", count2: " + count2);
    }

    public static void increment1(){
        synchronized(lock1) { // when synchronized keyword use at block level, we need to pass lock
            count1++;
        }
    }
    public static void increment2(){
        synchronized(lock2){
            count2++;
        }
    }
    public static void decrement1(){
        synchronized(lock1){
            count1--;
        }

    }
    public static void decrement2(){
        synchronized(lock2){
            count2--;
        }
    }
}

// Now the locks are non blocking exclusive
// As each lock is for different objects





