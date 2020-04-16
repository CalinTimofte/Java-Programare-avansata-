package info.uaic.ro.programare_avansata.lab8.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            createConn();
        }
        return conn;
    }

    private static void createConn() {
        String url = "jdbc:postgresql:musicalbums";
        try {
            conn = DriverManager.getConnection(url, "postgres", "sql");
        } catch (SQLException e) {
            System.err.println("Connection not possible");
        }
    }

    public Database() {
        getConn();
    }
}
