/*
    This code initialize all database needed to run in local mode
    To access database go to http://localhost:8082/ with these options:
        + JDBC URL: jdbc:h2:~/testDb
        + User Name: sa
        + Password: (None)
    Also you need to update your classpath / resources, this is done in the pom.xml
 */

package initialize;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitDatabase {
    public static void main(String[] args) {
        try {
            // Start the H2 Console
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println("H2 Console started at http://localhost:8082");

            // Use a persistent file-based H2 database
            Connection connection = DriverManager.getConnection("jdbc:h2:~/testDb;AUTO_SERVER=TRUE;INIT=RUNSCRIPT FROM 'classpath:database.sql'", "sa", "");
            System.out.println("Database connection is valid: " + connection.isValid(0));

            // Keep the application running until the user presses Enter
            System.out.println("Press Enter to exit...");
            System.in.read();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
