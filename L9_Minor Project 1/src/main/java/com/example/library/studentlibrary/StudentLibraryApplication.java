package com.example.library.studentlibrary;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.repositories.CardRepository;
import com.example.library.studentlibrary.repositories.StudentRepository;
import com.example.library.studentlibrary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StudentLibraryApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	@Autowired
	StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("abc@gmail.com", "ABC", 40, "Slovakia");

		Card card = new Card();

		student.setCard(card);
		card.setStudent(student);

		cardRepository.save(card);

		studentService.deleteStudent(1);

//		System.out.println(studentRepository.findStudentByEmailBySQL("abc@gmail.com"));
//
//		System.out.println(studentRepository.updateStudentEmail("abc@gmail.com",  "abc123@gmail.com"));



//		cardRepository.findAll().stream().forEach(System.out::println);

		// select card0_.id as id1_0_0_, card0_.created_on as created_2_0_0_, card0_.updated_on as updated_3_0_0_ from card card0_ where card0_.id=?
	}
}
