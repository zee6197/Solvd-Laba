package com.laba.solvd.HW_ShoppingMallApp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threader extends Thread {


    @Override
    public void run() {
        System.out.println("The thread's name is: " + Thread.currentThread().getName());
    }


    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i++) {
            executor.execute(new Threader());
        }

    }
}
