package Exam2020.Services;

import Exam2020.Models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface StudentService extends CRUDService<Student, Long> {
        List<Student> findStudentByName(String name);
}
