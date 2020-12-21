package Exam2020.Models;

import javax.persistence.*;

@Entity
//Without @Table the default table name is Student
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    /**
     * Many students for one supervisor
     */
    @ManyToOne
    @JoinColumn(name = "supervisor_id")//Defines the owning side by having a foreign key TODO WHY AM I GETTING ERROR!?
    private Supervisor supervisor;

    /**
     *  Protected Constructor for JPA only
     */
    protected Student() {}

    /**
     * Constructor.
     * @param name
     * @param email

     */
    public Student(String name, String email) {
        this.name = name;
        this.email = email;

    }

    @Override
    public String toString() {
        return String.format(
                "Student[id=%d, name='%s', email='%s', supervisor='%s']",
                id, name, email, supervisor.getName());
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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
