package me.sathish.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoansMSReponseDTO {
    private String errorCode;
    private String errorString;
}
