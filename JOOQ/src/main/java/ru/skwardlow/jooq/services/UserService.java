package ru.skwardlow.jooq.services;

import ru.skwardlow.jooq.dao.UsersDAO;

import java.sql.SQLException;

public class UserService {
    public static void createDeveloper(int id, String fio, String email, String phone) throws SQLException {
        UsersDAO.createUser(id, fio, email, phone);
    }

    public static String readDevelopers() throws SQLException {
        return UsersDAO.readDevelopers();
    }

    public static void updateDeveloper(int id, String fio, String email, String phone) throws SQLException {
        UsersDAO.updateUser(id, fio, email, phone);
    }

    public static void deleteDeveloper(int id) throws SQLException {
        UsersDAO.deleteUser(id);
    }
}
