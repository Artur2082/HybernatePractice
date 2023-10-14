package ua.javaPro.hibernatePractice.oneToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.javaPro.hibernatePractice.config.HibernateSession;
import ua.javaPro.hibernatePractice.oneToOne.Student;

import java.util.List;

public class StudentDAO {
    public void getAll() {
        try (Session session = HibernateSession.getSession()) {
            List list = session.createQuery
                    ("from Student").list();
            System.out.println(list);
        }
    }

    public void insert(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("Data is Added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getById(int number) {
        Transaction transaction = null;
        Student student;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(" FROM Student WHERE id = :id");
            query.setParameter("id", number);
            List result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                student = (Student) result.get(0);
                System.out.println("Finding by id = " + number + '\n' + student);
            } else {
                System.out.println("id = " + number + '\n' + "There is no such ID in data base");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getByIdWithoutQuery(int num) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, num);
            if (student == null) {
                System.out.println("Student not found !");
            } else {
                System.out.println(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getByName(String name) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Student where name = :name");
            query.setParameter("name", name);
            List<Student> listStudents = query.getResultList();
            if (listStudents != null && !listStudents.isEmpty())
                System.out.println(listStudents);
            else {
                System.out.println("There is no name such " + name);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(String name, int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE Student set name = :name WHERE id = :id");
            query.setParameter("name", name);
            query.setParameter("id", number);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateWithoutQuery(String name, int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, number);
            student.setName(name);
            System.out.println(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteById(int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, number);
            if (student != null) {
                Query query = session.createQuery("DELETE FROM Student WHERE id = :id");
                query.setParameter("id", number);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteByIdWithoutQuery(int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, number);
            session.remove(student);
            System.out.println("Student removed from data base");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
