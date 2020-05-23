package data;

import java.sql.*;

public class DBConnection {
  private String url = "jdbc:mysql://localhost:3306/restdb?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private String username = "root";
  private String password = "mouna";
  private Connection connection;
  private static DBConnection instance;

  private DBConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.connection = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public static DBConnection getInstance() {
    if (instance == null) {
      instance = new DBConnection();
    }
    return instance;
  }
}