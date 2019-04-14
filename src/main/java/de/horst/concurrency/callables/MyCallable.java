package de.horst.concurrency.callables;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
	
	private final long countUntil;
	
	public MyCallable(long countUntil) {
        this.countUntil = countUntil;
        System.out.println("input:" + this.countUntil);
    }


	@Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
            System.out.println("sum+:" + sum);
        }
        System.out.println("total:" + sum);
        return sum;
    }
}