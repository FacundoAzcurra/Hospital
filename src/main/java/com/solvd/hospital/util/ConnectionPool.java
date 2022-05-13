package com.solvd.hospital.util;


import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool{

    private final String URL = "jdbc:mysql://localhost:3306/";

    private final String USER = "root";

    private final String PASS = "devintern";

    private static ConnectionPool datasource;

    private BasicDataSource dataSource = null;

    private ConnectionPool() {

        dataSource = new BasicDataSource();
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
        dataSource.setUrl(URL);
        dataSource.setInitialSize(2);
        dataSource.setMinIdle(3);
        dataSource.setMaxIdle(20);
        dataSource.setMaxTotal(40);
        dataSource.setMaxWaitMillis(10000);

    }

}
