package Exam2020.Controllers;

import Exam2020.Models.AjaxResponseBody;
import Exam2020.Models.SearchCriteria;
import Exam2020.Models.Student;
import Exam2020.Services.StudentService;
import Exam2020.Services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    StudentService studentService;
    SupervisorService supervisorService;

    AjaxResponseBody result= new AjaxResponseBody();;

    @Autowired
    public StudentController(StudentService studentService, SupervisorService supervisorService) {
        this.studentService = studentService;
        this.supervisorService = supervisorService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {
        System.out.println("Search Called ");

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }

        List<Student> students = studentService.findByName(search.getName());
        if (students.isEmpty()) {
            result.setMsg("no student found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(students);

        return ResponseEntity.ok(result);
    }

    @PostMapping("api/allStudents")
    public List<Student> getAllStudentsViaAjax(){
        List<Student> students = studentService.findAll();

        return students;
    }

    @PostMapping("/api/addStudent")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, Errors errors) {
        System.out.println("Add Student Called " + student.getName() + student.getEmail());

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }

        List<Student> students = studentService.findAll();

        students.add(student);

        if (students.isEmpty()) {
            result.setMsg("no student found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(students);

        return ResponseEntity.ok(result);
    }

}
