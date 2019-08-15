package ru.skwardlow.services;

import ru.skwardlow.dao.UserDao;
import ru.skwardlow.entities.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public User findUser(int id){
        return userDao.findById(id);
    }

    public void saveUser(User user){
        userDao.saveUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public  void deleteUser(Integer id){
        userDao.deleteUser(id);
    }

    public List<User> getAll(){
        return userDao.getAll();
    }


}
