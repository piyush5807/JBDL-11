package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    // 1. Function (T) -> R // T can be equal to R
    // 2. Consumer (T)
    // 3. Predicate (T) -> boolean
    // 4. Supply () -> T
    // 5. Runnable ()

    public static void main(String[] args) {

//        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Bangalore");
//
//        cities.stream().filter(x -> {
//            System.out.println("Thread = " + Thread.currentThread().getName());
//            return x.startsWith("D");
//        }).map(x -> {
//            System.out.println("Thread = " + Thread.currentThread().getName());
//            return x.toLowerCase();
//        }).forEach(x -> {
//            System.out.println("Thread = " + Thread.currentThread().getName());
//            System.out.println(x);
//        });

        List<Integer> numbers = Arrays.asList(1, 4, 2, 3, 6, 5, 8, 10, 9, 2);

        long start = System.currentTimeMillis();

        System.out.println(numbers.stream().filter(x -> {
            System.out.println("Filtering x " + x  + " in thread " + Thread.currentThread().getName()); // t1
            return x % 2 == 0;
        }).map(x -> {
            System.out.println("Mapping x " + x  + " in thread " + Thread.currentThread().getName());
            return x * x;
        }).reduce(0, (x, y) -> {
            System.out.println("Reducing x " + x  + " in thread " + Thread.currentThread().getName());
            return x + y;
        }));

        System.out.println(System.currentTimeMillis() - start);
    }

//        cities.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("D");
//            }
//        }).map(new Function<String, String>() {
//
//            @Override
//            public String apply(String s) {
//                return s.toLowerCase();
//            }
//        }).forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//    }
}
