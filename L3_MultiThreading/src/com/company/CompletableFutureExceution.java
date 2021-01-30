package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureExceution {

    // parallelism
    // asynchronous

    public static CompletableFuture<BigInteger> compute(int x){
//        System.out.println("Computing factorial of " + x + " in thread :" + Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(new Supplier<BigInteger>() {
            @Override
            public BigInteger get() {
//                System.out.println("Calculating factorial of " + x + " in thread :" + Thread.currentThread().getName());
                BigInteger result =  BigInteger.valueOf(1);
                for(int i = 2; i <= x; i++){
                    result = result.multiply(BigInteger.valueOf(i));
                }

                return result;
            }
        });
    }

    public static BigInteger calculateFactorial(int x){
//        System.out.println("Calculating factorial of " + x + " in thread :" + Thread.currentThread().getName());
        BigInteger result =  BigInteger.valueOf(1);
        for(int i = 2; i <= x; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] arr = {10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000,
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000};

//        int[]arr = {4, 3, 5, 6, 1};

        List<CompletableFuture<BigInteger>> completableFutureList = new ArrayList<>();

        long start = System.currentTimeMillis();

        for(int i=0;i<arr.length;i++){
            int ele = arr[i];
            CompletableFuture<BigInteger> future = compute(arr[i]);

            completableFutureList.add(future);
            future
                    .thenApply(x -> x.add(BigInteger.ONE))
                    .thenAccept(x -> System.out.println("the result of ele " + ele + " is " + x))
                    .thenRun(() -> System.out.println("Printed the result finally for ele " + ele));

        }

        completableFutureList.stream().forEach(x -> {
            try {
                x.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

//        Thread.sleep(3000);



        System.out.println("Ending here!!");
        System.out.println(System.currentTimeMillis() - start);


    }
}
