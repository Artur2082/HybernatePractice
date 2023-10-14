package ua.javaPro.hibernatePractice.oneToOne;

public class MainStudentDAO {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Details details = new Details("0964565", "Sumy");
        Student student = new Student("Vasyl", "vasya@com", details);
        //studentDAO.insert(student);
        studentDAO.getByIdWithoutQuery(3);
    }
}
