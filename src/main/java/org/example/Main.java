/*
    Step by step:
        1. Run InitDatabase to initialize live local datbase
        2. Run Main
 */

package org.example;

import utils.DatabaseUtils;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Initialize DatabaseUtils with the file-based H2 database connection
        DatabaseUtils db = null;
        try {
            // Use the same persistent database URL (ensure AUTO_SERVER=TRUE)
            db = new DatabaseUtils("jdbc:h2:~/testDb;AUTO_SERVER=TRUE", "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Example
        selectAll(db);
    }


    // ************** This part contains example function **************
    // 1. Select all recipes
    private static void selectAll(DatabaseUtils db) {
        System.out.println("Selecting all recipes:");
        List<List<Object>> users = null;
        try {
            users = db.selectAll("recipes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (List<Object> user : users) {
            System.out.println(user);
        }
    }

}
