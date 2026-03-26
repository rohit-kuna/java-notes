package javaMultithreading.synchronization;

public class _4SynchronizationMethodLevelBlockingIssue {
    private static int count1=0;
    private static int count2=0;
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

    public static synchronized void increment1(){
        count1++;
    }
    public static synchronized void increment2(){
        count2++;
    }
    public static synchronized void decrement1(){
        count1--;
    }
    public static synchronized void decrement2(){
        count2--;
    }
}

// Now increment1/decrement1 is working on a diff resource from increment2/decrement2, i.e. count1 and count2
// but as these methods are static it occupies class level lock as there is a ingle class level monitor


