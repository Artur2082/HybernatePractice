package ua.javaPro.hibernatePractice.manyToMany;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbtest", name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "updated_at")
    private Date updatedAt;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "lesson_schedule",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id"))
    private List<Schedule> scheduleList;

    public Lesson() {
    }

    public Lesson(String name, Date updatedAt) {
        this.name = name;
        this.updatedAt = updatedAt;
    }

    public void addScheduleToLesson(Schedule schedule) {
        if (scheduleList == null) {
            scheduleList = new ArrayList<>();
        }
        scheduleList.add(schedule);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedAt=" + updatedAt +
                '}' + '\n';
    }
}