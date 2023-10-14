package ua.javaPro.hibernatePractice.manyToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.javaPro.hibernatePractice.config.HibernateSession;


import java.util.List;

public class PersonDAO {
    public void getAll() {
        try (Session session = HibernateSession.getSession()) {
            List list = session.createQuery
                    ("from Person").list();
            System.out.println(list);
        }
    }
    public void insert (CountryPerson country) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            session.persist(country);
            transaction.commit();
            System.out.println("Data is Added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void getByIdCountry(int num) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            CountryPerson country = session.get(CountryPerson.class, num);
            if (country == null) {
                System.out.println("Country not found !");
            } else {
                System.out.println(country);
                System.out.println(country.getPeople());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void getByIdPerson(int num) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, num);
            if (person == null) {
                System.out.println("Country not found !");
            } else {
                System.out.println(person);
                System.out.println(person.getCountry());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void update (String name, int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, number);
            person.setName(name);
            System.out.println(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void deleteById (int number) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSession()) {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, number);
            session.remove(person);
            System.out.println("person removed from data base");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
