package ua.javaPro.hibernatePractice;

import ua.javaPro.hibernatePractice.entity.StudentEntity;

public class MainSessionHibernateQueries {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentEntity student = new StudentEntity("John", "john@gmail.com");
        studentDAO.insert(student);
        studentDAO.getAll();
        studentDAO.getByIdWithoutQuery(2);
        studentDAO.update("Artur", 5);
        studentDAO.getAll();
        studentDAO.getById(5);
        studentDAO.getByName("Olga");
        studentDAO.updateWithoutQuery("Oleg", 5);
        studentDAO.deleteByIdWithoutQuery(23);
        studentDAO.getAll();
    }
}
