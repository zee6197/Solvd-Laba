package com.laba.solvd.HW_ShoppingMallApp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolUser implements Runnable {
    public void run() {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            System.out.println("Got a connection: " + Thread.currentThread().getName());

            // Simulating work with the connection
            Thread.sleep(1000);

            pool.releaseConnection(connection);
            System.out.println("Released a connection: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            executor.execute(new PoolUser());
        }
        executor.shutdown();
    }
}
