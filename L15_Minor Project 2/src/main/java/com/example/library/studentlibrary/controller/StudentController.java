package com.example.library.studentlibrary.controller;

import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.security.AuthorityConstants;
import com.example.library.studentlibrary.security.User;
import com.example.library.studentlibrary.security.UserRepository;
import com.example.library.studentlibrary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/all")
    public ResponseEntity getAllStudents(){
        return new ResponseEntity<>("The list of all the students is - " + null, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getStudent(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        Student obj = studentService.getDetails(username);
        return new ResponseEntity<>("Student details - " + obj, HttpStatus.OK);
    }

    @GetMapping("/studentById")
    public ResponseEntity getStudentById(@RequestParam("id") int id){
        Student obj = studentService.getDetailsById(id);
        return new ResponseEntity<>("Student details - " + obj, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user =  User.builder()
                .username(student.getEmailId())
                .password(encoder.encode("pass1234"))
                .authority(AuthorityConstants.STUDENT_AUTHORITY)
                .build();
        userRepository.save(user);

        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    // curl -XPUT "127.0.0.1:8080/updateStudent" -d'{"name": "Piyush", "email": "p@gmail.com", id}'

    @PutMapping("/")
    public ResponseEntity updateStudent(@RequestBody Student student){

        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update_password")
    public ResponseEntity updatePassword(@RequestParam("new_password") String new_password){

        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getName();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String new_encoded_password = encoder.encode(new_password);
//
//        userRepository.

        return null;
    }
}
