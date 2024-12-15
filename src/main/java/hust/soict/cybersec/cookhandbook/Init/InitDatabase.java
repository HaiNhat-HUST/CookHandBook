package hust.soict.cybersec.cookhandbook.Init;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitDatabase {
    public static void initAllDatabase() {
        try {
            // Start the H2 Console
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println("H2 Console started at http://localhost:8082");

            // Use a persistent file-based H2 database
            Connection connection = DriverManager.getConnection("jdbc:h2:~/testDb;AUTO_SERVER=TRUE;INIT=RUNSCRIPT FROM 'classpath:init.sql'", "sa", "");
            System.out.println("Database connection is valid: " + connection.isValid(0));

            // Keep the application running until the user presses Enter
            System.out.println("Press Enter to exit...");
            System.in.read();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}