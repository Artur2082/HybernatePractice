package ua.javaPro.hibernatePractice.manyToMany;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbtest", name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "updated_at")
    private Date updatedAt;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "lesson_schedule",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private List<Lesson> lessonList;

    public Schedule() {
    }

    public Schedule(String name, Date updatedAt) {
        this.name = name;
        this.updatedAt = updatedAt;
    }

    public void addLessonToSchedule(Lesson lesson) {
        if (lessonList == null) {
            lessonList = new ArrayList<>();
        }
        lessonList.add(lesson);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedAt=" + updatedAt +
                '}' + '\n';
    }
}
