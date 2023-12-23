package me.sathish.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoanDTO {

    @NotEmpty(message = "Phone Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    @NotEmpty(message = "Invalid Loan Number")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @NotEmpty(message = "Invalid Loan Type - Cannot be empty")
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;
}
