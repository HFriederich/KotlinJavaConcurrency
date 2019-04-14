package de.horst.concurreny.threadpools;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyMainPool {
    private static final int NTHREDS = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 3; i++) {
            Runnable worker = new MyRunnablePool(1L + i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        try {
			System.out.println(executor.awaitTermination(1000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Finished all threads");
    }
}
