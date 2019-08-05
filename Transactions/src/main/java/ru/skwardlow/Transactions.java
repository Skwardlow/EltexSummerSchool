package ru.skwardlow;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {
    @SneakyThrows(SQLException.class)
    public static void main(String[] args) {
        String simpleString = "ROSSIYA SVACHENNAYA NASHA DERZHAVA";
        Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        Statement statement = connection.createStatement();
        SQLfunc.initSQL();


        long time = System.currentTimeMillis();
        for(Integer i=0; i<10;i++){
            statement.executeUpdate("INSERT INTO Compare VALUE ('"+simpleString+i.toString()+"');");
        }
        long time1 = System.currentTimeMillis();
        System.out.println("Without Transactions = "+(time1-time));

        SQLfunc.initSQL();

        time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for(Integer i=0; i<10;i++){
            statement.executeUpdate("INSERT INTO Compare VALUE ('"+simpleString+i.toString()+"');");
        }
        connection.commit();
        connection.setAutoCommit(true);
        time1 = System.currentTimeMillis();
        System.out.println("With Transaction = "+(time1-time));



    }
}
