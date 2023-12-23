package me.sathish.loans.mapper;

import me.sathish.loans.dto.LoanDTO;
import me.sathish.loans.entities.Loan;

public class LoansMapper {
    public static LoanDTO mapToLoansDto(Loan loans, LoanDTO loanDto) {
        loanDto.setLoanNumber(loans.getLoanNumber());
        loanDto.setLoanType(loans.getLoanType());
        loanDto.setPhoneNumber(loans.getPhoneNumber());
        loanDto.setTotalLoan(loans.getTotalLoan());
        loanDto.setAmountPaid(loans.getAmountPaid());
        loanDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loanDto;
    }

    public static Loan mapToLoans(LoanDTO loanDto, Loan loans) {
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setPhoneNumber(loanDto.getPhoneNumber());
        loans.setTotalLoan(loanDto.getTotalLoan());
        loans.setAmountPaid(loanDto.getAmountPaid());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loans;
    }
}
