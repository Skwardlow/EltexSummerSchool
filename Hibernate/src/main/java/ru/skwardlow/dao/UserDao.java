package ru.skwardlow.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skwardlow.entities.User;
import ru.skwardlow.utils.HibernateFactoryUtil;

import java.util.List;

public class UserDao {
    public User findById(Integer id){
        return HibernateFactoryUtil.getSessionFactory().openSession().get(User.class,id);
    }

    public void saveUser(User user){
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    public void updateUser(User user){
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    public void deleteUser(Integer id) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(findById(id));
        tx.commit();
        session.close();
    }

    public List<User> getAll(){
        return  HibernateFactoryUtil.getSessionFactory().openSession().createQuery("FROM User ").list();
    }
}
