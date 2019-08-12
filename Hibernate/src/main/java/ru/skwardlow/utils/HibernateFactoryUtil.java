package ru.skwardlow.utils;

import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.skwardlow.entities.Address;
import ru.skwardlow.entities.Lang;
import ru.skwardlow.entities.Passport;
import ru.skwardlow.entities.User;

@NoArgsConstructor
public class HibernateFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Passport.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Lang.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

        }
        return sessionFactory;
    }

}
