package me.sathish.loans.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import me.sathish.loans.dto.LoanDTO;
import me.sathish.loans.dto.LoanMSReponseDTO;
import me.sathish.loans.entities.Loan;
import me.sathish.loans.response.PagedResult;
import me.sathish.loans.services.LoanService;
import me.sathish.loans.utils.LoanMSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
@Validated
@Slf4j
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public PagedResult<Loan> getAllLoans(
            @RequestParam(
                            value = "pageNo",
                            defaultValue = LoanMSConstants.DEFAULT_PAGE_NUMBER,
                            required = false)
                    int pageNo,
            @RequestParam(
                            value = "pageSize",
                            defaultValue = LoanMSConstants.DEFAULT_PAGE_SIZE,
                            required = false)
                    int pageSize,
            @RequestParam(
                            value = "sortBy",
                            defaultValue = LoanMSConstants.DEFAULT_SORT_BY,
                            required = false)
                    String sortBy,
            @RequestParam(
                            value = "sortDir",
                            defaultValue = LoanMSConstants.DEFAULT_SORT_DIRECTION,
                            required = false)
                    String sortDir) {
        return loanService.findAllLoans(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return loanService
                .findLoanById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create/{phoneNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LoanMSReponseDTO> createLoan(
            @PathVariable
                    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
                    String phoneNumber) {
        loanService.saveLoan(phoneNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new LoanMSReponseDTO(
                                LoanMSConstants.STATUS_201, LoanMSConstants.MESSAGE_201));
    }

    @PutMapping("/update/{phoneNumber}")
    public ResponseEntity<LoanMSReponseDTO> updateLoan(@Valid @RequestBody LoanDTO loanDto) {
        boolean isUpdated = loanService.updateLoan(loanDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new LoanMSReponseDTO(
                                    LoanMSConstants.STATUS_200, LoanMSConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            new LoanMSReponseDTO(
                                    LoanMSConstants.STATUS_417,
                                    LoanMSConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/{phoneNumber}")
    public ResponseEntity<LoanMSReponseDTO> deleteLoan(
            @PathVariable
                    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
                    String phoneNumber) {
        boolean isDeleted = loanService.deleteLoanById(phoneNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new LoanMSReponseDTO(
                                    LoanMSConstants.STATUS_200, LoanMSConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            new LoanMSReponseDTO(
                                    LoanMSConstants.STATUS_417,
                                    LoanMSConstants.MESSAGE_417_DELETE));
        }
    }
}
