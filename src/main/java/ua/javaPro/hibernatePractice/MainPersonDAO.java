package ua.javaPro.hibernatePractice;

import ua.javaPro.hibernatePractice.entity.CountryPerson;
import ua.javaPro.hibernatePractice.entity.PersonManyToOne;

public class MainPersonDAO {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        CountryPerson ukraine = new CountryPerson("Ukraine", "ukrainian", 200, 1000);
        PersonManyToOne person1 = new PersonManyToOne("Mykola", "male", 500);
        PersonManyToOne person2 = new PersonManyToOne("Sofia", "female", 700);
//        ukraine.addPersonToCountry(person1);
//        ukraine.addPersonToCountry(person2);
        personDAO.getAll();
    }
}
