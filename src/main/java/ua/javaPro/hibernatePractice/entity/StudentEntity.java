package ua.javaPro.hibernatePractice.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "dbtest", name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private StudentDetails details;

    public StudentEntity(String name, String email, StudentDetails details) {
        this.name = name;
        this.email = email;
        this.details = details;
    }
    public StudentEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDetails(StudentDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", details=" + details +
                '}'+ '\n';
    }
}
