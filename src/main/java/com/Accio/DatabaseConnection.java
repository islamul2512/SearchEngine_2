package com.Accio;

//import jdk.dynalink.beans.StaticClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        String user = "root";
        String pwd = "Md@8969684321";
        String db = "searchengine_2";
        return getConnection(user, pwd, db);

    }
    private static Connection getConnection(String user, String pwd, String db){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc://localhost/" + db + "?user=" + user + "&password=" + pwd);
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + user + "&password=" + pwd);
        }catch (SQLException | ClassNotFoundException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}
