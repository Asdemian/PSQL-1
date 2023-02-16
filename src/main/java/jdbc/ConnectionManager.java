package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/skypro";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";


    private ConnectionManager() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                URL, USER, PASSWORD);
    }

}
