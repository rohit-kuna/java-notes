package javaMultithreading.joinThread;
public class BackgroundUserThreadExample {
    public static void main(String[] args) {
        Thread bgThread = new Thread(new DaemonHelper());
        Thread usrThread = new Thread(new UserThreadHelper());
        bgThread.setDaemon(true); // making it as Daemon thread


        // Now starting
        bgThread.start();
        usrThread.start();

        /*
        daemon helper: 1
        daemon helper: 2
        daemon helper: 3
        daemon helper: 4
        User thread done with execution

        Hence though the count of daemon thread is not complete it is forced to shutdown as user thread execution is complete, user thraed took 5 seconds and daemon thread was said to print count every second
         */
    }
}

class DaemonHelper implements Runnable {
    @Override
    public void run(){
        int count = 0;
        while(count<500){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            count++;
            System.out.println("daemon helper: " + count);
        }
    }
}

class UserThreadHelper implements Runnable {
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
        System.out.println("User thread done with execution");
    }
}

/*
- User threads are given priority
- Bg threads run in the Background
- When usr thread completes, the app closes all bg threads too and shuts down
 */
