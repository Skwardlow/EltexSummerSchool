package ru.skwardlow.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.skwardlow.mongo.entities.User;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    MongoOperations mongoOperations;

    public void save(User user){
        mongoOperations.save(user);
    }

    public User get(String id){
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)),User.class);
    }

    public List<User> getall(){
        return mongoOperations.findAll(User.class);
    }

    public void remove(String id){
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)),User.class);
    }

}
