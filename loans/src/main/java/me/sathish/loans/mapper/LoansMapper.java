package me.sathish.loans.mapper;

import me.sathish.loans.dto.LoansDTO;
import me.sathish.loans.entities.Loan;

public class LoansMapper {
    public static LoansDTO mapToLoansDto(Loan loans, LoansDTO loansDto) {
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setPhoneNumber(loans.getPhoneNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }

    public static Loan mapToLoans(LoansDTO loansDto, Loan loans) {
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setPhoneNumber(loansDto.getPhoneNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }
}
