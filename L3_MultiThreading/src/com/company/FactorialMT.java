package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class FactorialMT {

    public static void main(String[] args) throws InterruptedException {
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
                10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000

        }; // 50 elements

        long start  = System.currentTimeMillis();

        MyThread[] thread_arr = new MyThread[arr.length];

        for(int i = 0; i < thread_arr.length; i++){
            thread_arr[i] = new MyThread(arr[i]);
            thread_arr[i].start();
        }

        for(int i=0;i<thread_arr.length;i++){
            thread_arr[i].join(); // thread - 0 10 sec and after every 2 sec scheduler 10 + 5
            System.out.println("For no - " + arr[i] + ", ans = " + thread_arr[i].result);
        }

        System.out.println("Time taken to execute is " + (System.currentTimeMillis() - start));

        // File upload

        // 1. async programming in which my main thread instead of sitting idle can do something
        // 2. 8 threads in parallel,  OS - thrashing // poorly

        // Executors CompletableFuture Future


        // 50 elements - 7 thread
    }

    private static class MyThread extends Thread{

        int num;
        BigInteger result;
        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.valueOf(1);
        }

        @Override
        public void run() {
            for(int i = 2; i <= this.num; i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}
