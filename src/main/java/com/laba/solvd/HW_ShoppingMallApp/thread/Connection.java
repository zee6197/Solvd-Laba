package com.laba.solvd.HW_ShoppingMallApp.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void showConnect() {
        LOGGER.info("Yes it is connected");
    }
}