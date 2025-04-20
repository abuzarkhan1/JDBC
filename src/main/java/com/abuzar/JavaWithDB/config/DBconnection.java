package com.abuzar.JavaWithDB.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "abuzar";

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
