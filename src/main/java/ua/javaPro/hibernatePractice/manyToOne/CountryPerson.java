package ua.javaPro.hibernatePractice.manyToOne;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbtest", name = "country")
public class CountryPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String language;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "max_salary")
    private int maxSalary;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "country", fetch = FetchType.EAGER)
    private List<Person> people;
    public CountryPerson() {
    }

    public CountryPerson(String name, String language, int minSalary, int maxSalary) {
        this.name = name;
        this.language = language;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
    public void addPersonToCountry(Person person){
        if(people == null){
            people = new ArrayList<>();
        }
        people.add(person);
        person.setCountry(this);
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}' + '\n';
    }
}
