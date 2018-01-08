package sqltask.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            Connection db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/data_tasks", "postgres", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
