package ru.skwardlow;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;

public class SQLfunc {
    @SneakyThrows(SQLException.class)
    protected static void showALL () {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        DBTablePrinter.printTable(connection, "Developers");
        DBTablePrinter.printTable(connection, "Managers");
    }

    @SneakyThrows(SQLException.class)
    protected  static void checkTableNotExist (){
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Managers ( id INT NOT NULL AUTO_INCREMENT, " +
                "fio varchar(20), phone varchar(15), mailbox varchar(20), sales varchar(100), primary key(id) );\n");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Developers ( id INT NOT NULL AUTO_INCREMENT," +
                "fio varchar(20), phone varchar(15), mailbox varchar(20), langs varchar(30), primary key(id) );\n");
    }

}
