package ru.skwardlow;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;

public class SQLfunc {
    @SneakyThrows(SQLException.class)
    protected static void showALL () {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();

        DBTablePrinter.printTable(connection, "Developers");
        DBTablePrinter.printTable(connection, "Managers");
    }

}
