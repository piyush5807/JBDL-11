package com.example.library.studentlibrary.controller;

import com.example.library.studentlibrary.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
       String externalTransactionId = transactionService.issueBook(cardId, bookId);
       return new ResponseEntity<>("transaction completed, here is your transactionId - " + externalTransactionId, HttpStatus.ACCEPTED);
    }

    @PostMapping("/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        String externalTransactionId = transactionService.returnBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed, here is your transactionId - " + externalTransactionId, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity getTransactionsForCard(@RequestParam("cardId") int cardId){
        return new ResponseEntity<>("The list of transactions " + null, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getTransactions(){
        return new ResponseEntity<>("The list of transactions " + null, HttpStatus.OK);
    }
}
