package de.horst.concurrency.threads;

public class MyRunnable implements Runnable {

	private final long countUntil;

    MyRunnable(long countUntil) {
        this.countUntil = countUntil;
        System.out.println(Thread.currentThread().getName() + " input:" + this.countUntil);
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + " sum+:" + sum);
        }
        System.out.println(Thread.currentThread().getName() + " total:" + sum);
    }

}
