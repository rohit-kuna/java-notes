package javaMultithreading.joinThread;
public class _1ThreadPriorityExample {
    public static void main(String[] args){
        Thread t1=new Thread(()->{
            for(int i=0;i<=15;i++){
                System.out.println("thread t1 :"+i);
            }
        });

        System.out.println(Thread.currentThread().getName()+" : says hi");
        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();
    }
}
