package hust.soict.cybersec.cookhandbook.model.utils;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppDb {
    private static Connection conn;
    private static String url = "jdbc:h2:~/testDb";
    private static String user = "sa";
    private static String password = "";

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}