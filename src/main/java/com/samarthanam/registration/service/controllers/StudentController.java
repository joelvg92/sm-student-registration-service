package com.samarthanam.registration.service.controllers;

import com.samarthanam.registration.service.models.Student;
import com.samarthanam.registration.service.payload.response.MessageResponse;
import com.samarthanam.registration.service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= {"http://localhost:4200","https://sm-angular-ui.herokuapp.com"}, maxAge = 4800, allowCredentials = "true" )
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
        Student studentResponse = studentRepository.save(student);
        return ResponseEntity.ok().body(studentResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student,@PathVariable Long id) {
        Student studentResponse = null;
        Optional<Student> student1 = studentRepository.findById(id);
        if(student1!=null){
             studentResponse = studentRepository.save(student);
        }else{
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid Id"));
        }
        return ResponseEntity.ok().body(studentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<Student> studentResponse = studentRepository.findById(id);
        return ResponseEntity.ok().body(studentResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> studentResponse = studentRepository.findAll();
        return ResponseEntity.ok().body(studentResponse);
    }

}
