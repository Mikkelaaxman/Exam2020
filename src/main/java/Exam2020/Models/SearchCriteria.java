package Exam2020.Models;

// import org.hibernate.validator.constraints.NotBlank; Deprecated!
import javax.validation.constraints.NotEmpty;


public class SearchCriteria {
    @NotEmpty(message = "name can't empty!")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
