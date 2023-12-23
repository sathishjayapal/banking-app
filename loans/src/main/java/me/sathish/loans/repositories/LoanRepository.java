package me.sathish.loans.repositories;

import me.sathish.loans.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByPhoneNumber(String mobileNumber);

    Optional<Loan> findByLoanNumber(String loanNumber);
}
