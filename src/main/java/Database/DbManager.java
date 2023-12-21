package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
    private static String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11671217";
    private static String user = "sql11671217";
    private static String pass = "XAErw8hPMl";

    public static Statement drawQuery () throws SQLException {
            Connection connection = DriverManager.getConnection(url,user,pass);
            return connection.createStatement();

    }
}
