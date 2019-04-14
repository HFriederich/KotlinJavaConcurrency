package de.horst.concurreny.threadpools;

/**
 * MyRunnable will count the sum of the number from 1 to the parameter
 * countUntil and then write the result to the console.
 * <p>
 * MyRunnable is the task which will be performed
 *
 **/

public class MyRunnablePool implements Runnable {

	private final long countUntil;

    MyRunnablePool(long countUntil) {
        this.countUntil = countUntil;
        System.out.println("input:" + this.countUntil);
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
            System.out.println("input:" + this.countUntil + " sum+:" + sum);
        }
        System.out.println("input:" + this.countUntil + " total:" + sum);
    }

}
