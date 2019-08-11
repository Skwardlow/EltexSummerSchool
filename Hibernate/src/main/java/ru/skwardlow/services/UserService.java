package ru.skwardlow.services;

import ru.skwardlow.dao.UserDao;
import ru.skwardlow.entities.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User findUser(int id){
        return userDao.findById(id);
    }

    public void saveUser(User user){
        userDao.saveUser(user);
    }
}
