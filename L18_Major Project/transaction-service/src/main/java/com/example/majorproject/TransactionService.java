package com.example.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RestTemplate restTemplate;

    private static final String WALLET_UPDATE_TOPIC = "wallet_update";
    private static final String SEND_EMAIL_TOPIC = "send_email";

    public void createTransaction(TransactionRequest transactionRequest) throws JsonProcessingException {

        Transaction transaction = Transaction.builder()
                .fromUser(transactionRequest.getFromUser())
                .toUser(transactionRequest.getToUser())
                .amount(transactionRequest.getAmount())
                .transactionTime(new Date().toString())
                .externalId(UUID.randomUUID().toString())
                .status(TransactionStatus.PENDING.toString())
                .purpose(transactionRequest.getPurpose())
                .build();

        transactionRepository.save(transaction);

        // make a call to wallet service to update the wallets of sender and receiver

        JSONObject walletRequest = new JSONObject();
        walletRequest.put("fromUser", transaction.getFromUser());
        walletRequest.put("toUser", transaction.getToUser());
        walletRequest.put("amount", transaction.getAmount());
        walletRequest.put("transactionId", transaction.getExternalId());

        kafkaTemplate.send(WALLET_UPDATE_TOPIC, objectMapper.writeValueAsString(walletRequest));
    }

    @KafkaListener(topics = {"transaction_update"}, groupId = "test1234")
    public void updateTransaction(String message) throws JsonProcessingException {

        JSONObject transactionUpdateRequest = objectMapper.readValue(message, JSONObject.class);
        String transactionId = (String)transactionUpdateRequest.get("transactionId");
        String status  = (String) transactionUpdateRequest.get("status");

        transactionRepository.updateTransaction(transactionId, status);
        Transaction transaction = transactionRepository.findByExternalId(transactionId);

        String fromUser  = transaction.getFromUser();
        String toUser = transaction.getToUser();

        URI url = URI.create("http://localhost:7000/user?userId=" + fromUser);
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        JSONObject fromUserObject = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JSONObject.class).getBody();

        String fromUserEmail = (String)fromUserObject.get("email");
        JSONObject emailRequest = new JSONObject();
        emailRequest.put("toUser", fromUserEmail);
        emailRequest.put("message", String.format(" Hi %s, your transaction with id %s got %s",
                        fromUser,
                        transactionId,
                        status));
        kafkaTemplate.send(SEND_EMAIL_TOPIC, fromUser, objectMapper.writeValueAsString(emailRequest));

        if(status.equals(TransactionStatus.REJECTED.toString())){
            return;
        }

        url = URI.create("http://localhost:7000/user?userId=" + toUser);
        JSONObject toUserObject = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JSONObject.class).getBody();

        String toUserEmail = (String)toUserObject.get("email");
        emailRequest = new JSONObject();
        emailRequest.put("toUser", toUserEmail);
        emailRequest.put("message", String.format(" Hi %s, you got %d amount from %s",
                toUser,
                transaction.getAmount(),
                fromUser));
        kafkaTemplate.send(SEND_EMAIL_TOPIC, toUser, objectMapper.writeValueAsString(emailRequest));


    }
}
