package javaMultithreading.joinThread;
public class _4JoinThreadExampleCorrected {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<=5;i++){
                System.out.println("Thread t1: "+i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<=10;i++){
                System.out.println("Thread t2: "+ i);
            }
        });

        System.out.println("Before executing the threads...");
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException ex){
            //
        }
        System.out.println("Done executing the threads");

        // Everything is in sequence now
        // main thread is the parent thread
        // main waits for the completion of child threads

    }
}
