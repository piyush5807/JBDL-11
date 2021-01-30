package com.company;

import java.math.BigInteger;
import java.util.Arrays;

public class Factorial {

    // 1. correctness
    // 2. performance

    public static void main(String[] args) {
        int[] arr = {10000, 20000, 35000, 60000, 10000, 80000, 50000, 40000};
//        int[] small_arr = {1, 3, 2, 4, 6, 7, 5};

        long start = System.currentTimeMillis(); // epoch time
        Arrays.stream(arr).mapToObj(Factorial::calculate).forEach(System.out::println);

        System.out.println("Time taken to execute : " + (System.currentTimeMillis() - start));

    }

    public static BigInteger calculate(int x){

        BigInteger result = BigInteger.valueOf(1);

        for(int i = 2; i <= x; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
