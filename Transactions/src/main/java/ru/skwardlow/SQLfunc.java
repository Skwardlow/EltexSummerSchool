package ru.skwardlow;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLfunc {

    @SneakyThrows(SQLException.class)
    public static void initSQL(){
        Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE  IF EXISTS Compare");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Compare (str VARCHAR (50))");

    }
}
