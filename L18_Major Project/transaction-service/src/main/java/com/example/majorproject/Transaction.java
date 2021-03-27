package com.example.majorproject;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String externalId = UUID.randomUUID().toString(); // external id to query
    private String fromUser; // sender
    private String toUser; // receiver
    private String purpose;
    private String status;
    private int amount;
    private String transactionTime;
}
