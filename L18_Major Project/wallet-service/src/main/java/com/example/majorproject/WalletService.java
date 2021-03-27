package com.example.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Value("${wallet.amount.default}")
    int default_wallet;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final String TRANSACTION_UPDATE_TOPIC = "transaction_update";

    // TODO: add a listener annotation here
    @KafkaListener(topics = {"wallet_create"}, groupId = "test1234")
    public void createWallet(String message) throws JsonProcessingException {

        JSONObject walletRequest = objectMapper.readValue(message, JSONObject.class);

        Wallet wallet = Wallet.builder()
                .userId((String)walletRequest.get("userId"))
                .balance(default_wallet).build();
        walletRepository.save(wallet);
    }

    @KafkaListener(topics = {"wallet_update"}, groupId = "test1234")
    public void updateWallets(String message) throws JsonProcessingException {

        JSONObject walletUpdateRequest = objectMapper.readValue(message, JSONObject.class);
        String fromUser = (String)walletUpdateRequest.get("fromUser");
        String toUser = (String)walletUpdateRequest.get("toUser");
        String transactionId = (String)walletUpdateRequest.get("transactionId");
        int amount  = (Integer) walletUpdateRequest.get("amount");
        Wallet senderWallet = walletRepository.findByUserId(fromUser);


        JSONObject transactionUpdate = new JSONObject();

        if(senderWallet.getBalance() < amount){
            transactionUpdate.put("transactionId", transactionId);
            transactionUpdate.put("status", "REJECTED");

            kafkaTemplate.send(TRANSACTION_UPDATE_TOPIC, objectMapper.writeValueAsString(transactionUpdate));
            return;
        }

        walletRepository.updateWallet(fromUser, 0 - amount);
        walletRepository.updateWallet(toUser, amount);

        transactionUpdate.put("status", "COMPLETED");
        transactionUpdate.put("transactionId", transactionId);

        kafkaTemplate.send(TRANSACTION_UPDATE_TOPIC, objectMapper.writeValueAsString(transactionUpdate));
    }
}
