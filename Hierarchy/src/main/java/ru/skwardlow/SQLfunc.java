package ru.skwardlow;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;

public class SQLfunc {
    @SneakyThrows(SQLException.class)
    protected static void showALL () {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        DBTablePrinter.printTable(connection, "Developers");
        DBTablePrinter.printTable(connection,"LangUnity");
        DBTablePrinter.printTable(connection,"Langs");
        DBTablePrinter.printTable(connection,"Managers");
        DBTablePrinter.printTable(connection,"SalesUnity");
        DBTablePrinter.printTable(connection,"Sales");
    }

    @SneakyThrows(SQLException.class)
    protected static void showAllUnion(){
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Developers UNION SELECT * FROM Managers");
        DBTablePrinter.printResultSet(resultSet);
    }

    @SneakyThrows(SQLException.class)
    protected  static void checkTableNotExist (){
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();

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

    @SneakyThrows(SQLException.class)
    protected static void deleteTabs(){
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        statement.executeUpdate("drop table if exists Managers;");
        statement.executeUpdate("drop table if exists SalesUnity;");
        statement.executeUpdate("drop table if exists Sales");
        statement.executeUpdate("drop table if exists Developers;");
        statement.executeUpdate("drop table if exists LangUnity;");
        statement.executeUpdate("drop table if exists Langs;");
    }

    @SneakyThrows(SQLException.class)
    protected static boolean containCheck(String tabName, String colName, String searchFor){
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT "+colName+" FROM "+tabName+" where "+colName+" =" +
                " '"+searchFor+"'");;
        return resultSet.next();
    }

    @SneakyThrows(SQLException.class)
    protected static int returnID(String tabName, String colName, String searchFor,String wantedResultColumn){
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT "+wantedResultColumn+" FROM "+tabName+" where "+colName+" =" +
                " '"+searchFor+"'");
        resultSet.next();
        return resultSet.getInt(wantedResultColumn);
    }

}
