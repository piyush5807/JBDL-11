package com.example.library.studentlibrary.repositories;

import com.example.library.studentlibrary.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // JPQL - Java Persistence Query Language // objects and attributes
    // Native SQL Query // columns and tables

    @Modifying
    @Query("update Student s set s.emailId = :#{#std.emailId}, " +
            "s.name = :#{#std.name}, " +
            "s.age = :#{#std.age} ," +
            "s.country = :#{#std.country} " +
            "where s.id = :#{#std.id}")
    int updateStudentDetails(Student std);


    @Modifying
    @Query("delete from Student s where s.id =:id")
    void deleteCustom(int id);

    Student findByEmailId(String email);

    // Poor Design
//    @Query("update Student s set s.emailId =:email where s.id =:id")
//    int updateStudentEmailId(String email, int id);

//    @Query("select b from Student b where b.emailId =:mail")
//    public List<Student> findStudentByName(String mail);
//
//    @Query(value = "select * from student s where s.email_id =:mail", nativeQuery = true)
//    public List<Student> findStudentByEmailBySQL(String mail);
//
//    @Modifying
//    @Query("update Student s set s.emailId =:newEmail where s.emailId =:oldEmail")
//    public int updateStudentEmail(String oldEmail, String newEmail);
}
