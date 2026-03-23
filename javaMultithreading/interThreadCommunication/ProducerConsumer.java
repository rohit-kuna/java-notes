package javaMultithreading.interThreadCommunication;

import java.util.Queue;
import java.util.LinkedList;

public class ProducerConsumer {
    public static void main(String[] args) {

        int size = 5;
        Worker worker = new Worker(size);

        Thread producer = new Thread(() -> {
            int value = 0;
            try {
                while (true) {
                    worker.producer(value++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    worker.consumer();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}

class Worker {

    private final int limit;
    private final Queue<Integer> buffer = new LinkedList<>();

    Worker(int limit) {
        this.limit = limit;
    }

    public synchronized void producer(int value) throws InterruptedException {

        while (buffer.size() == limit) {
            wait(); // wait if full
        }

        buffer.offer(value);
        System.out.println("Produced: " + value);

        notifyAll(); // notify consumers as value is available
    }

    public synchronized void consumer() throws InterruptedException {

        while (buffer.isEmpty()) {
            wait(); // wait if empty
        }

        int consumedVal = buffer.poll();
        System.out.println("Consumed: " + consumedVal);

        notifyAll(); // notify producers as value is consumed
    }
}


/*
    catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }

WHY restore interrupt?

Because:

Catching it clears the interrupt flag
If you don’t restore → system loses interruption signal

This can break:

Thread pools
Executors
Graceful shutdown
*/
