package javaMultithreading.interThreadCommunication;

public class WaitAndNotify {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            try {
                synchronized(LOCK){
                    System.out.println(Thread.currentThread().getName() + " - before");
                    LOCK.wait(); // will stop the further code execution instantly
                    System.out.println(Thread.currentThread().getName() + " - after");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // TODO: handle exception
            }
        });

        Thread t2 = new Thread(()->{
            synchronized(LOCK){
                System.out.println(Thread.currentThread().getName() + " - before");
                LOCK.notify(); // won't stop the further process instantly but wait for the further all calls to process before notifiying
                System.out.println(Thread.currentThread().getName() + " - after");
            }
        });

        t1.start();
        t2.start();
    }
}

/*
 * wait : makes the thread wait for some reason
 * sleep : makes the thread pause execution for given duration
 *
 * notify : randomly wakes up a thread waiting for lock
 * notifyAll : wakes up all threads waiting for a lock
 */
