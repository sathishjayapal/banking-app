package me.sathish.bank.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {
    @NotEmpty(message = "Account Number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account Type cannot be a null or empty")
    private String accountType;

    @NotEmpty(message = "Bank Address cannot be a null or empty")
    private String bankAddress;
}
