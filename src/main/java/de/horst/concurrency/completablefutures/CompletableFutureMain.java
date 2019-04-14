package de.horst.concurrency.completablefutures;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureMain {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();
	    for (int i = 0; i < 3; i++) {
        // configure CompletableFuture
        CompletableFuture<Integer> futureCount = createCompletableFuture(i +1);

            // continue to do other work
            System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds" );
	    
            // now its time to get the result
            try {
              int count = futureCount.get();
                System.out.println(Thread.currentThread().getName() + " CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );

               System.out.println(Thread.currentThread().getName() + " Result " + count);
             } catch (InterruptedException | ExecutionException ex) {
                // Exceptions from the future should be handled here
            }
	    }
	    System.out.println(Thread.currentThread().getName() + " finished");
    }

    private static CompletableFuture<Integer> createCompletableFuture(int countUntil) {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                () -> {
                	System.out.println(Thread.currentThread().getName() + " countUntil:" + countUntil);
                	int sum = 0;
                    try {
                    	
                        for (long i = 1; i < countUntil; i++) {
                            sum += i;
                            System.out.println(Thread.currentThread().getName() + " sum+:" + sum);
                        }
                        System.out.println(Thread.currentThread().getName() + " total:" + sum);
                        // simulate long running task
                         Thread.sleep(5000);
                    } catch (InterruptedException e) { }
                    return sum;
                    //try {
                        // simulate long running task
                        //Thread.sleep(5000);
                    //} catch (InterruptedException e) { }
                    //return 20;
                });
        return futureCount;
    }

}
