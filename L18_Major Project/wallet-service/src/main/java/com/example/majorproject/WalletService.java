package com.example.majorproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Value("${wallet.amount.default}")
    int default_wallet;

    @Autowired
    WalletRepository walletRepository;

    // TODO: add a listener annotation here
    public void createWallet(String userId){
        Wallet wallet = Wallet.builder().userId(userId).amount(default_wallet).build();
        walletRepository.save(wallet);
    }

    // amount - 100
    public WalletResponse incrementWallet(String userId, int amount){
        return walletRepository.incrementWallet(userId, amount).toResponse();
    }

    public WalletResponse decrementWallet(String userId, int amount){
        return walletRepository.decrementWallet(userId, amount).toResponse();
    }
}
