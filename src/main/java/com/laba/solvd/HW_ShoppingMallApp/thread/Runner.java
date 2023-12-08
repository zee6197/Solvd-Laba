package com.laba.solvd.HW_ShoppingMallApp.thread;


public class Runner implements Runnable {

    private String message;

    Runner(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }

    public static void main(String[] args) {

        // 2 Threads using Runnable interface:
        Runner firstObject = new Runner("Welcome!");
        Runner secondObject = new Runner("Thread running using Runnable");
        Thread thread1 = new Thread(firstObject);
        Thread thread2 = new Thread(secondObject);

        thread1.start();
        try {
            Thread.sleep(30);
        } catch (Exception e){
            System.out.println("Please note there is an error here");
        }
        thread2.start();
    }
}