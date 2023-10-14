package ua.javaPro.hibernatePractice.manyToOne;


public class MainPersonDAO {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        CountryPerson usa = new CountryPerson("USA", "american", 900, 4000);
//        PersonManyToOne person1 = new PersonManyToOne("Bob", "male", 900);
//        PersonManyToOne person2 = new PersonManyToOne("Ann", "female", 1700);
//        PersonManyToOne person3 = new PersonManyToOne("Tony", "male", 1900);
//        usa.addPersonToCountry(person1);
//        usa.addPersonToCountry(person2);
//        usa.addPersonToCountry(person3);
//        personDAO.insert(usa);
        personDAO.getByIdCountry(4);
    }
}
