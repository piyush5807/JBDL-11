package com.example.library.studentlibrary.repositories;

import com.example.library.studentlibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("select b from Book b where b.available =:availability and b.author in (select a from Author a where a.name =:author_name)")
    List<Book> findBooksByAuthor(String author_name, boolean availability);

    @Query("select b from Book b where b.genre =:genre and b.available =:available")
    List<Book> findBooksByGenre(String genre, boolean available);

    @Query("select b from Book b where b.available =:available and b.genre =:genre and b.author in (select a from Author a where a.name =:author_name)")
    List<Book> findBooksByGenreAuthor(String genre, String author, boolean available);

    @Query(value = "select * from book b where b.available =:availabilty", nativeQuery = true)
    List<Book> findByAvailability(boolean availabilty);


    @Modifying
    @Transactional
    @Query("update Book b set b.available =:#{#book.available}, b.card =:#{#book.card} where b.id =:#{#book.id}")
    int updateBook(Book book);

}
