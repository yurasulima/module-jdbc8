package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database INSTANCE;

    private Database() {
    }


    static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:h2:tcp://localhost/~/test";
        String dbUser = "sa";
        String dbPass = "";
        return DriverManager.getConnection(dbUrl, dbUser, dbPass);
    }
}
