package ua.javaPro.hibernatePractice.manyToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.javaPro.hibernatePractice.config.HibernateSession;


public class LessonScheduleDAO {
    public void insertSchedule(Schedule schedule) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            session.persist(schedule);
            transaction.commit();
            System.out.println("Schedule is Added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void insertLesson(Lesson lesson) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            session.persist(lesson);
            transaction.commit();
            System.out.println("LESSON is Added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getByIdLesson(int num) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, num);
            if (lesson == null) {
                System.out.println("lesson not found !");
            } else {
                System.out.println(lesson);
                System.out.println(lesson.getScheduleList());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getByIdSchedule(int num) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Schedule schedule = session.get(Schedule.class, num);
            if (schedule == null) {
                System.out.println("lesson not found !");
            } else {
                System.out.println(schedule);
                System.out.println(schedule.getLessonList());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteLesson(int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, number);
            session.remove(lesson);
            System.out.println("Lesson removed from data base");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteSchedule(int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Schedule schedule = session.get(Schedule.class, number);
            session.remove(schedule);
            System.out.println("Schedule removed from data base");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
