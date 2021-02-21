package com.example.library.studentlibrary.repositories;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CardRepository extends JpaRepository<Card, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update card c set c.card_status =:status where c.id in (select card_id from student s where s.id =:student_id)", nativeQuery = true)
    void deactivateCard(int student_id, String status);
}
