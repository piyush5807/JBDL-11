package com.example.majorproject;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private String fromUser;
    private String toUser;
    private int amount;
    private String purpose;

}
