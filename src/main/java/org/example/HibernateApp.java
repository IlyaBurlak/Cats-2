package org.example;

import org.example.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;

public class HibernateApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Cat.class);

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/Cat");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1207");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Cat cat = new Cat();
        cat.setName("Pun");
        cat.setBirthDate(LocalDate.parse("2008-10-12"));
        cat.setBreed("Персидский");
        cat.setColor("Серый");
        cat.setOwnerId(1L);

        session.save(cat);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}