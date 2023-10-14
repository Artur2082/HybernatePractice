package ua.javaPro.hibernatePractice;

import ua.javaPro.hibernatePractice.entity.StudentDetails;
import ua.javaPro.hibernatePractice.entity.StudentOneToOne;

public class MainStudentDAO {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentDetails details = new StudentDetails("0964565", "Sumy");
        StudentOneToOne student = new StudentOneToOne("Vasyl", "vasya@com", details);
        //studentDAO.insert(student);
        studentDAO.getByIdWithoutQuery(3);
    }
}
