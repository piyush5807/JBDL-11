package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.repositories.CardRepository;
import com.example.library.studentlibrary.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    CardService cardService;

    @Autowired
    StudentRepository studentRepository;

    public Student getDetails(String email){
        return studentRepository.findByEmailId(email);
    }

    public Student getDetailsById(int id){
        return studentRepository.findById(id).get();
    }

    public void createStudent(Student student){
        Card newCard = cardService.createAndReturn(student);
        logger.info("The card for the student {} is created with the details - {}", student, newCard);

    }

    public void updateStudent(Student student){
        studentRepository.updateStudentDetails(student);
    }

    public void deleteStudent(int id){

        cardService.deactivateCard(id);
        studentRepository.deleteCustom(id);
    }
}
