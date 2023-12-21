package me.sathish.bank.dto;

import lombok.Data;

@Data
public class AccountsDTO {
    private Long customerId;
    private Long accountNumber;
    private String accountType;
    private String bankAddress;
}
