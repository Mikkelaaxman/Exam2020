package Exam2020.JPA;

import Exam2020.Models.Student;
import Exam2020.Models.Supervisor;
import Exam2020.Repos.StudentRepo;
import Exam2020.Services.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Could be called our StudentServiceImplementation, this is where the businesslogic happens.
 */
@Service
public class StudentJPA implements StudentService {
    private List<Student> students;

    private final StudentRepo studentRepo;

    public StudentJPA(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //Java 8 lambda art
    @Override
    public List<Student> findStudentByName(String name) {
        List<Student> result = students.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return result;
    }

    // Init some students for testing
    @PostConstruct
    private void iniDataForTesting() {

        students = new ArrayList<Student>();
        Supervisor supervisor1 = new Supervisor("Jon", "Jone@kea.dk");  //TODO Find supervisor


        Student student1 = new Student("Mikkel", "mikk990@kea.dk", supervisor1);
        Student student2 = new Student("Bob", "bob123@kea.dk", supervisor1);

        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> findAll() {
        List<Student> result = new ArrayList<>();
        studentRepo.findAll().forEach(result::add); //adds iterable to list
        return result;
    }

    @Override
    public Student save(Student object) {
        return studentRepo.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepo.deleteById(aLong);
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }
}
