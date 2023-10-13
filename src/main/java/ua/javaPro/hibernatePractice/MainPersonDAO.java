package ua.javaPro.hibernatePractice;

import ua.javaPro.hibernatePractice.entity.Country;
import ua.javaPro.hibernatePractice.entity.Person;

public class MainPersonDAO {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        Country ukraine = new Country("Ukraine", "ukrainian", 200, 1000);
        Person person1 = new Person("Mykola", "male", 500);
        Person person2 = new Person("Sofia", "female", 700);
        ukraine.addPersonToCountry(person1);
        ukraine.addPersonToCountry(person2);
        personDAO.getAll();
    }
}
