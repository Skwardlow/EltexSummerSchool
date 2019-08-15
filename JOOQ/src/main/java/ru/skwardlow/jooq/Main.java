package ru.skwardlow.jooq;

import ru.skwardlow.jooq.services.UserService;
import ru.skwardlow.jooq.utils.SQLfunc;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLfunc.checkTableNotExist();
        System.out.println(UserService.readDevelopers());
        UserService.createDeveloper(20,"Dima","asas@dfdf","+7894561230");
        System.out.println(UserService.readDevelopers());
        UserService.updateDeveloper(20,"Mima","12@qw","-0321654987");
        System.out.println(UserService.readDevelopers());
        UserService.deleteDeveloper(20);
        System.out.println(UserService.readDevelopers());
    }
}
