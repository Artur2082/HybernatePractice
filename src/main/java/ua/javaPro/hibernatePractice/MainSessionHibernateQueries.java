package ua.javaPro.hibernatePractice;

import ua.javaPro.hibernatePractice.entity.StudentEntity;

public class MainSessionHibernateQueries {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentEntity student = new StudentEntity("John", "john@gmail.com");
        studentDAO.insert(student);
        studentDAO.getAll();
        studentDAO.getByIdNew(2);
        studentDAO.deleteById(22);
        studentDAO.update("Joseph", 5);
        studentDAO.getAll();
        studentDAO.getById(5);

    }
}
