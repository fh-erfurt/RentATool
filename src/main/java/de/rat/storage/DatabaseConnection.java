package de.rat.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Database connection Class
Established Connection via JDBC with a MySQL Database.
Includes parameter and exception handling if connection could not established.
 */

public abstract class DatabaseConnection {


    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static Connection getConnection() throws Exception{
        Connection existingConnection = null;

        try{
            //Connection parameter
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/rentatool"; //ToDo test connection
            String username = "root";
            String password = "";
            Class.forName(driver);

            existingConnection = DriverManager.getConnection(url,username,password);
            LOG.log(Level.INFO, "Database Connection successfully established");

            return existingConnection;

        } catch (ClassNotFoundException | SQLException e){
            LOG.log(Level.INFO, "Database connection could not be established : " + e);
        }

        return existingConnection;
    }

    public static void disconnectDatabase(Connection existingConnection) throws Exception{
        try{
            existingConnection.close();
            LOG.log(Level.INFO, "Database successfully disconnected");
        } catch (Exception e) {
            LOG.log(Level.INFO, "Database couldn't be disconnected, reason: " + e);
        }
    }
}