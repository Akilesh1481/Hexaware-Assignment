package com.app.config;

import com.app.model.Booking;
import com.app.model.Flight;
import com.app.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.app")
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {

        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/flight_db");
        cfg.setProperty("hibernate.connection.username","root");
        cfg.setProperty("hibernate.connection.password","Achu2004@");
        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(Flight.class);
        cfg.addAnnotatedClass(Booking.class);

        return cfg.buildSessionFactory();
    }
}