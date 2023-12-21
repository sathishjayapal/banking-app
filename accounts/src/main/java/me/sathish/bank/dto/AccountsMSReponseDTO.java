package me.sathish.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsMSReponseDTO {
    private String errorCode;
    private String errorString;
}
