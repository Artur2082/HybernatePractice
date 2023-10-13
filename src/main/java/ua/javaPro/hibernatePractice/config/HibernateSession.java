package ua.javaPro.hibernatePractice.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ua.javaPro.hibernatePractice.entity.Country;
import ua.javaPro.hibernatePractice.entity.Person;
import ua.javaPro.hibernatePractice.entity.StudentDetails;
import ua.javaPro.hibernatePractice.entity.StudentEntity;

public class HibernateSession {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            initSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void initSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addPackage("ua.javaPro.hibernatePractice.entity");
        configuration.addAnnotatedClass(StudentEntity.class);
        configuration.addAnnotatedClass(StudentDetails.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/dbtest");
        configuration.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        configuration.setProperty(Environment.USER, "root");
        configuration.setProperty(Environment.PASS, "Velhjcnm0228");
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        configuration.setProperty(Environment.CONNECTION_PROVIDER, "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
