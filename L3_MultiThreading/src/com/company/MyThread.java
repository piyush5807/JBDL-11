//package com.company;
//
//public class MyThread {
//
//    // int[]arr = {10000, 20000, 30000, 12000, 60000}
//    // Q1. Find the factorial of elements in the array
//
//    public static void main(String[] args) {
//
//        System.out.println("I am at line no 7, thread is " + Thread.currentThread().getName());
//
//        Thread thread = new Thread(() -> System.out.println("I am in run function,  the thread " + Thread.currentThread().getName()));
//        Thread thread = new Thread(() -> System.out.println("I am in run function,  the thread " + Thread.currentThread().getName()));
//        Thread thread = new Thread(() -> System.out.println("I am in run function,  the thread " + Thread.currentThread().getName()));
//        Thread thread = new Thread(() -> System.out.println("I am in run function,  the thread " + Thread.currentThread().getName()));
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("I am in run function,  the thread " + Thread.currentThread().getName());
//            }
//        });
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("I am in run function,  the thread " + Thread.currentThread().getName());
//            }
//        });
//
//        thread.start();
//
//        System.out.println("I am at line no 18, thread is " + Thread.currentThread().getName());
//    }
//
//
//
//}
