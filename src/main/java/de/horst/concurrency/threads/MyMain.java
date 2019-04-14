package de.horst.concurrency.threads;

import java.util.ArrayList;
import java.util.List;

public class MyMain {

	public static void main(String[] args) {
        // We will store the threads so that we can check if they are done
        List<Thread> threads = new ArrayList<Thread>();
        // We will create 3 threads //500
        for (int i = 0; i < 3; i++) {
            Runnable task = new MyRunnable(1L + i); //10000000L
            Thread worker = new Thread(task);
            // We can set the name of the thread
            worker.setName(String.valueOf(i));
            // Start the thread, never call method run() direct
            worker.start();
            // Remember the thread for later usage
            threads.add(worker);
        }
//        int running = 0;
//        do {
//            running = 0;
//            for (Thread thread : threads) {
//                if (thread.isAlive()) {
//                    running++;
//                }
//            }
//            System.out.println("We have " + running + " running threads. ");
//        } while (running > 0);
         System.out.println(Thread.currentThread().getName() + " finished");
    }

	

}
