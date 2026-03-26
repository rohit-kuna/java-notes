package javaMultithreading.joinThread;
public class _3JoinThreadExampleIssue {
    public static void main(String[] args) {
        Thread t1 =new Thread(()->{
            for(int i=0;i<=5;i++){
                System.out.println("Thread t1: "+i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<=10;i++){
                System.out.println("Thread t2: "+i);
            }
        });

        t1.start();
        t2.start();
        System.out.println("Done executing the threads");

        /*
         *  OP : Done executing the threads
            Thread t1: 0
            Thread t1: 1
            Thread t1: 2
            Thread t1: 3
         */

        /*
         * We want the Done exceuting to be printed first and then t1 and t2,
        But here that doesn't happen as main thread executes it's things first, though the threads do start
         */
    }
}
