package ru.skwardlow.jooq.utils;

import java.sql.*;

public class SQLfunc {
    public static void showALL() throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());

    }

    public static void checkTableNotExist() throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Managers ( id INT NOT NULL AUTO_INCREMENT, " +
                "fio varchar(20), phone varchar(15), mailbox varchar(20), primary key(id) );\n");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Developers ( id INT NOT NULL AUTO_INCREMENT," +
                "fio varchar(20), phone varchar(15), mailbox varchar(20), primary key(id) );\n");
        //Creating 2NF unity tables DEV
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS LangUnity (id_Dev INT NOT NULL , id_Lang INT" +
                " );\n");
        statement.executeUpdate(("CREATE TABLE IF NOT EXISTS Langs (id INT NOT NULL AUTO_INCREMENT, lang varchar(10)," +
                "primary key (id));\n"));
        //Creating 2NF unity tables MAN
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS SalesUnity (id_Man INT NOT NULL , id_Sale INT," +
                " primary key (id_Man,id_Sale));\n");
        statement.executeUpdate(("CREATE TABLE IF NOT EXISTS Sales (id INT NOT NULL AUTO_INCREMENT, sale varchar(30)," +
                "cost varchar(15),primary key (id));\n"));
    }

    public static void deleteTabs() throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        Statement statement = connection.createStatement();
        statement.executeUpdate("drop table if exists Managers;");
        statement.executeUpdate("drop table if exists SalesUnity;");
        statement.executeUpdate("drop table if exists Sales");
        statement.executeUpdate("drop table if exists Developers;");
        statement.executeUpdate("drop table if exists LangUnity;");
        statement.executeUpdate("drop table if exists Langs;");
    }

    public static boolean containCheck(String tabName, String colName, String searchFor) throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + colName + " FROM " + tabName + " where " + colName + " =" +
                " '" + searchFor + "'");
        ;
        return resultSet.next();
    }

    public static int returnID(String tabName, String colName, String searchFor, String wantedResultColumn) throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + wantedResultColumn + " FROM " + tabName + " where " + colName + " =" +
                " '" + searchFor + "'");
        resultSet.next();
        return resultSet.getInt(wantedResultColumn);
    }


}
