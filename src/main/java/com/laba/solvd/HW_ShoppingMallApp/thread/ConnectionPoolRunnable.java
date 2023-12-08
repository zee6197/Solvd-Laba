package com.laba.solvd.HW_ShoppingMallApp.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolRunnable {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolRunnable.class);

    public static void main(String[] args) {

        ConnectionPool connectPool = new ConnectionPool();
        ExecutorService executor = Executors.newFixedThreadPool(7); // # of threads 7
        Runnable task = () -> {
            try {
                Connection connection = connectPool.getConnection();
                connection.showConnect();
                Thread.sleep(1000); // Simulating work
                LOGGER.info("Completed");
                connectPool.releaseConnection(connection);
            } catch (InterruptedException e) {
                LOGGER.error("An error occurred: ", e);
            }
        };
        for (int i = 0; i < 7; i++) {
            executor.execute(task);
        }
        executor.shutdown();
    }
}