package DbconnectPackage;

import java.sql.*;
import java.time.LocalDate;

public class DbConnection {
	
	public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "may19";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "admin";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
    } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
	
	public static Date getSQLDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }

}
