package ua.javaPro.hibernatePractice.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "dbtest", name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "phone_number")
    private String phone;

    private String city;

    public Details() {
    }

    public Details(String phone, String city) {
        this.phone = phone;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
