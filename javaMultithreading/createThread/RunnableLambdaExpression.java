package javaMultithreading.createThread;
public class RunnableLambdaExpression {
    public static void main(String[] args){
        Thread t1=new Thread(()->{
            for(int i=0;i<=10;i++){
                System.out.println("thread 1 : "+i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<=15;i++){
                System.out.println("thread 2: "+ i);
            }
        });

        t1.start();
        t2.start();

    }
}
