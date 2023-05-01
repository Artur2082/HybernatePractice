package ua.javaPro.hibernatePractice;

import org.hibernate.Session;
import ua.javaPro.hibernatePractice.entity.StudentEntity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateSession.getSession()) {
            List<StudentEntity> list = session.createQuery("SELECT A from StudentEntity A ", StudentEntity.class).list();
            System.out.println(list);
        }
    }
}
