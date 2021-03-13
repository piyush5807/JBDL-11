package com.example.library.studentlibrary;

import com.example.library.studentlibrary.models.*;
import com.example.library.studentlibrary.repositories.AuthorRepository;
import com.example.library.studentlibrary.repositories.BookRepository;
import com.example.library.studentlibrary.repositories.CardRepository;
import com.example.library.studentlibrary.repositories.StudentRepository;
import com.example.library.studentlibrary.security.AuthorityConstants;
import com.example.library.studentlibrary.security.User;
import com.example.library.studentlibrary.security.UserRepository;
import com.example.library.studentlibrary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentLibraryApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//		User user1 = User.builder()
//				.username("John")
//				.password(encoder.encode("john123"))
//				.authority(AuthorityConstants.ADMIN_AUTHORITY)
//				.build();
//
//		User user2 = User.builder()
//				.username("Jim")
//				.password(encoder.encode("jim123"))
//				.authority(AuthorityConstants.STUDENT_AUTHORITY)
//				.build();
//
//
//		userRepository.saveAll(Arrays.asList(user1));



//		List<Book> books = bookRepository.findAll();
//		Student student = new Student("abc@gmail.com", "ABC", 40, "Slovakia");
//
//		Card card = new Card();
//
//		student.setCard(card);
//		card.setStudent(student);
//
//		cardRepository.save(card);

//		Author author = new Author("William", "william@gmail.com", 45, "Italy");
//		Book book = new Book("Human Psychology", Genre.FICTIONAL, author);
//
//
//		authorRepository.save(author);
//
//		bookRepository.save(book);


//		studentService.deleteStudent(1);

//		System.out.println(studentRepository.findStudentByEmailBySQL("abc@gmail.com"));
//
//		System.out.println(studentRepository.updateStudentEmail("abc@gmail.com",  "abc123@gmail.com"));



//		cardRepository.findAll().stream().forEach(System.out::println);

		// select card0_.id as id1_0_0_, card0_.created_on as created_2_0_0_, card0_.updated_on as updated_3_0_0_ from card card0_ where card0_.id=?
	}
}
