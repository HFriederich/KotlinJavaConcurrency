package de.horst.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallbackMain {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

	    for (int i = 0; i < 3; i++) {
	    	System.out.println(Thread.currentThread().getName() + " i:" + i);;
        CompletableFuture<String>  data = createCompletableFuture(i + 1)
                .thenApply((Integer count) -> {
                    int transformedValue = count;
                    return transformedValue;
                }).thenApply(transformed -> Thread.currentThread().getName() + " Finally creates a string: " + transformed);

            try {
                System.out.println(Thread.currentThread().getName() + ":" + data.get());
            } catch (InterruptedException | ExecutionException e) {

            }
	    }   
    }

    public static CompletableFuture<Integer> createCompletableFuture(int countUntil) {
        CompletableFuture<Integer>  result = CompletableFuture.supplyAsync(() -> {
        	System.out.println(Thread.currentThread().getName() + " countUntil:" + countUntil);
        	int sum = 0;
            //try {
            	
                for (long i = 1; i < countUntil; i++) {
                    sum += i;
                    System.out.println(Thread.currentThread().getName() + " sum+:" + sum);
                }
                System.out.println(Thread.currentThread().getName() + " total:" + sum);
                // simulate long running task
                // Thread.sleep(5000);
            //} catch (InterruptedException e) { }
            return sum;
        });
        return result;
    }

}

