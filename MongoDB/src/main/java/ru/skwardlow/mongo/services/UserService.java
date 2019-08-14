package ru.skwardlow.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skwardlow.mongo.dao.UserDao;
import ru.skwardlow.mongo.entities.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public void add(User user){
        userDao.save(user);
    }

    public User get(String id){
        return userDao.get(id);
    }

    public List<User> getAll(){
        return userDao.getall();
    }

    public void remove(String id){
        userDao.remove(id);
    }
}
