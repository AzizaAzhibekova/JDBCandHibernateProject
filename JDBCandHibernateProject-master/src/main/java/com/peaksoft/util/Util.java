package com.peaksoft.util;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
=======


import com.peaksoft.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
>>>>>>> 9aba5b7 (Initial commit)
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";

<<<<<<< HEAD

    public static Connection connection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Successfully connected");
=======
    public static Connection connection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connected to the SQL");
>>>>>>> 9aba5b7 (Initial commit)
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
<<<<<<< HEAD
}
=======
    public  static SessionFactory getSessionFactory(){
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/postgres");
            prop.setProperty("hibernate.connection.username", "postgres");
            prop.setProperty("hibernate.connection.password", "postgres");
            prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
            prop.setProperty("hibernate.hbm2ddl.auto", "create");

            return new Configuration()
                    .addProperties(prop)
                    //.addPackage("com.kat")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}

























>>>>>>> 9aba5b7 (Initial commit)
