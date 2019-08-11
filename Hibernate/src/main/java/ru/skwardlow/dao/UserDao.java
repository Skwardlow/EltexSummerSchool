package ru.skwardlow.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skwardlow.entities.User;
import ru.skwardlow.utils.HibernateFactoryUtil;

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
}
