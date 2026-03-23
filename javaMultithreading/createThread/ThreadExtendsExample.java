package javaMultithreading.createThread;
public class ThreadExtendsExample {
    public static void main(String[] args){
        Thread t1 = new MyThread();
        t1.run();
        t1.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println("Thread: "+i);
        }
    }
}
