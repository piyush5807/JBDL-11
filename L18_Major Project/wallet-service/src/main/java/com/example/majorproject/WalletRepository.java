package com.example.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    @Modifying
    @Query("update Wallet w set w.amount = w.amount - :amount where w.userId = :userId")
    Wallet decrementWallet(String userId, int amount);

    @Modifying
    @Query("update Wallet w set w.amount = w.amount + :amount where w.userId = :userId")
    Wallet incrementWallet(String userId, int amount);

}
