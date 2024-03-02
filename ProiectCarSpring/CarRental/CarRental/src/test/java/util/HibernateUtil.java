package util;

import models.Car;
import models.Client;
import models.Order;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final String DB_USERNAME = "sa"; // poate fi inlocuit cu orice, fiind in memory
    private static final String DB_PASSWORD = "pwd"; // poate fi inlocuit cu orice, fiind in memory
    private static final String DB_HOST = "jdbc:h2:mem:testdb";
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactoryInstance() {
        if (sessionFactory == null) {
            instantiateSessionFactory();
        }
        return sessionFactory;
    }

    private static void instantiateSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.h2.Driver");

        properties.put(Environment.URL, DB_HOST);
        properties.put(Environment.USER, DB_USERNAME);
        properties.put(Environment.PASS, DB_PASSWORD);

        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.HBM2DDL_AUTO, "create");

        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Order.class);


        configuration.setProperties(properties);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
