package Exam2020.Models;

import javax.persistence.*;
import java.util.List;

@Entity
//Without @Table the default table name is Supervisor
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generated ID value
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student") //Maps to owning side where student has FK
    private List<Student> student;

    /**
     * For JPA
     */
    protected Supervisor()  {}

    /**
     * Constructor
     * @param name
     * @param email
     */
    public Supervisor(String name, String email) {
        this.name = name;
        this.email = email;

    }

    //Just nice to have
    @Override
    public String toString() {
        return String.format(
                "Supervisor[id=%d, name='%s', email='%s']",
                id, name, email);
    }

    /**
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
