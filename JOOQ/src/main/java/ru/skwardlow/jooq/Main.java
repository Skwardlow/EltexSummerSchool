package ru.skwardlow.jooq;

import ru.skwardlow.jooq.dao.UsersDAO;
import ru.skwardlow.jooq.utils.SQLfunc;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLfunc.checkTableNotExist();
        UsersDAO.createUser(20,"Dimas","123@4","+788945123");
        System.out.println(UsersDAO.readDevelopers());

    }

}
