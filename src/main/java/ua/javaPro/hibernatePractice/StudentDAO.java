package ua.javaPro.hibernatePractice;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.javaPro.hibernatePractice.entity.StudentEntity;
import java.util.List;

public class StudentDAO {

    public void getAll() {
        try (Session session = HibernateSession.getSession()) {
            List list = session.createQuery
                    ("from StudentEntity").list();
//            List<StudentEntity> list = session.createQuery
//                    ("SELECT A from StudentEntity A ", StudentEntity.class).list();
            System.out.println(list);
        }
    }

    public void insert(StudentEntity student) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            System.out.println("Data is Added");
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
            StudentEntity student = session.get(StudentEntity.class, number);
            if (student != null) {
                Query query = session.createQuery("DELETE FROM StudentEntity WHERE id = :id");
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

    public void getById(int number) {
        Transaction transaction = null;
        StudentEntity student;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(" FROM StudentEntity WHERE id = :id");
            query.setParameter("id", number);
            List result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                student = (StudentEntity) result.get(0);
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

    public void getByIdNew(int num) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            StudentEntity student = session.get(StudentEntity.class, num);
            if (student == null) {
                System.out.println("Student not found !");
            } else {
                System.out.println(student);
            }
        }catch (Exception e) {
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
            Query query = session.createQuery("UPDATE StudentEntity set name = :name WHERE id = :id");
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
}
