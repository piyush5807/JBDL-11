package com.example.majorproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @PutMapping("/wallet")
    public WalletResponse updateWallet(@RequestBody WalletRequest walletRequest){

        return (walletRequest.isIncrement()) ? walletService.incrementWallet(walletRequest.getUserId(), walletRequest.getAmount()) : walletService.decrementWallet(walletRequest.getUserId(), walletRequest.getAmount());


    }
}
