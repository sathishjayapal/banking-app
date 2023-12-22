package me.sathish.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotEmpty(message = "Customer Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "Customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email-id cannot be a null or empty")
    @Email(message = "Email-id should be a valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
    private String phoneNumber;

    private AccountsDTO accountsDto;
}
