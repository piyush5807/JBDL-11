package com.example.springjpa.demojpa.Repository;


import com.example.springjpa.demojpa.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {
}
