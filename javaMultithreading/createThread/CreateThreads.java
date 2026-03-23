package javaMultithreading.createThread;

public class CreateThreads {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        Thread t2 = new Thread(new Task2());
        t2.start();

        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("way 3");
            }
        });
        t3.start();

        Thread t4 = new Thread(()->{
            System.out.println("way 4");
        });
        t4.start();

        Thread t5 = new Thread(()->{
            helperMethod();
        });
        t5.start();

    }

    public static void helperMethod() {
        System.out.println("way 5");
    }
}

class MyThread1 extends Thread {
    @Override
    public void run(){
        System.out.println("way 1");
    }
}

class Task2 implements Runnable {
    @Override
    public void run(){
        System.out.println("way 2");
    }
}
