package Exam2020.Models;

import javax.validation.constraints.NotEmpty;

public class AddStudentResponse {
    @NotEmpty(message = "name can't be empty!")
    String name;
    @NotEmpty(message = "Email can't be empty!")
    String email;
    Long supervisor;

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

    public Long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
    }

}
