package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
    private static String url = "jdbc:mysql://localhost:3306/teamprogetto";
    private static String user = "developer@localhost";
    private static String pass = "pass1";

    public static Statement drawQuery () throws SQLException {
            Connection connection = DriverManager.getConnection(url,user,pass);
            return connection.createStatement();

    }
}
