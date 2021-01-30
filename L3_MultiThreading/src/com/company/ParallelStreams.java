package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreams {

    public static void main(String[] args) {
        // sum of squares of even nos
        // Ans = 4^2 + 2^2 + 6^2

        // 1 million records last 10 elements
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3, 6, 5, 8, 10, 9, 2);

        // t1 3 6 9
        // t2 1(0)  2(2) 10(n-2)
        // t3 4 5 8

//        numbers.parallelStream().forEach(System.out::println);

//        System.out.println(numbers.parallelStream().filter(x -> x % 2 == 0).map(x -> x * x).findFirst());

//        System.out.println(numbers.stream().filter(x -> x % 2 == 0).findFirst());

        // correctness over performance

        long start = System.currentTimeMillis();
        System.out.println(numbers.parallelStream().filter(x -> {
            System.out.println("Filtering x " + x  + " in thread " + Thread.currentThread().getName()); // t1
            return x % 2 == 0;
        }).map(x -> {
            System.out.println("Mapping x " + x  + " in thread " + Thread.currentThread().getName());
            return x * x;
        }).findFirst());

//        System.out.println(numbers.stream().filter(x -> {
//            System.out.println("Filtering x " + x  + " in thread " + Thread.currentThread().getName()); // t1
//            return x % 2 == 0;
//        }).map(x -> {
//            System.out.println("Mapping x " + x  + " in thread " + Thread.currentThread().getName());
//            return x * x;
//        }).findFirst());


//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println(ForkJoinPool.commonPool());
    }
}
