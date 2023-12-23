package me.sathish.loans.services;

import me.sathish.loans.dto.LoansDTO;
import me.sathish.loans.entities.Loan;
import me.sathish.loans.exception.LoanExistsException;
import me.sathish.loans.exception.ResourceNotFoundException;
import me.sathish.loans.mapper.LoansMapper;
import me.sathish.loans.repositories.LoanRepository;
import me.sathish.loans.response.PagedResult;
import me.sathish.loans.utils.LoanMSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public PagedResult<Loan> findAllLoans(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort =
            sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Loan> loansPage = loanRepository.findAll(pageable);
        return new PagedResult<>(loansPage);
    }

    public Optional<Loan> findLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan saveLoan(String phoneNumber) {
        Optional<Loan> optionalLoans = loanRepository.findByPhoneNumber(phoneNumber);
        if (optionalLoans.isPresent()) {
            throw new LoanExistsException(
                "Loan already registered with given mobileNumber " + phoneNumber);
        }
        return loanRepository.save(createNewLoan(phoneNumber));
    }

    /**
     * @param phoneNumber - Phone Number of the Customer
     * @return the new loan details
     */
    private Loan createNewLoan(String phoneNumber) {
        Loan newLoan = new Loan();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setPhoneNumber(phoneNumber);
        newLoan.setLoanType(LoanMSConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanMSConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanMSConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    public boolean deleteLoanById(String phoneNumber) {
        Loan loans =
            loanRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(
                    () ->
                        new ResourceNotFoundException(
                            "Loan", "phoneNumber", phoneNumber));
        loanRepository.deleteById(loans.getLoanId());
        return true;
    }

    public boolean updateLoan(LoansDTO loansDto) {
        Loan loans =
            loanRepository
                .findByLoanNumber(loansDto.getLoanNumber())
                .orElseThrow(
                    () ->
                        new ResourceNotFoundException(
                            "Loan", "LoanNumber", loansDto.getLoanNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loanRepository.save(loans);
        return true;
    }
}
