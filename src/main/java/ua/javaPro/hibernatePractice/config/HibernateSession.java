package ua.javaPro.hibernatePractice.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ua.javaPro.hibernatePractice.manyToOne.CountryPerson;
import ua.javaPro.hibernatePractice.manyToOne.Person;
import ua.javaPro.hibernatePractice.oneToOne.Details;
import ua.javaPro.hibernatePractice.oneToOne.Student;
import ua.javaPro.hibernatePractice.manyToMany.Lesson;
import ua.javaPro.hibernatePractice.manyToMany.Schedule;

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
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Details.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(CountryPerson.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Schedule.class);
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
