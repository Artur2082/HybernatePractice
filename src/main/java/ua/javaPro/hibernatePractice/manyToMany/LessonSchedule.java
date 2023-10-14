package ua.javaPro.hibernatePractice.manyToMany;

import jakarta.persistence.*;

@Entity
@Table(schema = "dbtest", name = "lesson_scedule")
public class LessonSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @JoinColumn(name = "lesson_id")
//    private Lesson lesson;
//    @JoinColumn(name = "schedule_id")
//    private Schedule schedule;

    public LessonSchedule() {
    }
}
