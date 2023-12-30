package me.sathish.bank.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import me.sathish.bank.dto.AccountCloudDTO;
import me.sathish.bank.dto.AccountMSIdentifierDTO;
import me.sathish.bank.dto.AccountsMSReponseDTO;
import me.sathish.bank.dto.CustomerDTO;
import me.sathish.bank.entities.Accounts;
import me.sathish.bank.response.PagedResult;
import me.sathish.bank.services.AccountService;
import me.sathish.bank.utils.AcoountMSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
@Validated
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {

    private final AccountService accountService;
    @Autowired Environment environment;
    private AccountMSIdentifierDTO accountsRecordDTO;
    private AccountCloudDTO accountCloudDTO;

    @Autowired
    public AccountController(AccountService accountService, AccountMSIdentifierDTO accountsRecordDTO, AccountCloudDTO accountCloudDTO) {
        this.accountsRecordDTO = accountsRecordDTO;
        this.accountService = accountService;
        this.accountCloudDTO= accountCloudDTO;
    }

    @GetMapping("/java-version")
    public ResponseEntity<AccountsMSReponseDTO> getAccountMSJVM() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new AccountsMSReponseDTO(
                                AcoountMSConstants.STATUS_200,
                                environment.getProperty("java.version")));
    }

    @GetMapping("/accounts-config")
    public ResponseEntity<AccountMSIdentifierDTO> getAccountMSIdentifier() {
        return ResponseEntity.status(HttpStatus.OK).body(accountsRecordDTO);
    }
    @GetMapping("/accounts-cloud")
    public ResponseEntity<AccountCloudDTO> getAccountMSCloudProviders() {
        return ResponseEntity.status(HttpStatus.OK).body(accountCloudDTO);
    }
    @GetMapping
    public PagedResult<Accounts> getAllAccounts(
            @RequestParam(
                            value = "pageNo",
                            defaultValue = AcoountMSConstants.DEFAULT_PAGE_NUMBER,
                            required = false)
                    int pageNo,
            @RequestParam(
                            value = "pageSize",
                            defaultValue = AcoountMSConstants.DEFAULT_PAGE_SIZE,
                            required = false)
                    int pageSize,
            @RequestParam(
                            value = "sortBy",
                            defaultValue = AcoountMSConstants.DEFAULT_SORT_BY,
                            required = false)
                    String sortBy,
            @RequestParam(
                            value = "sortDir",
                            defaultValue = AcoountMSConstants.DEFAULT_SORT_DIRECTION,
                            required = false)
                    String sortDir) {
        return accountService.findAllAccounts(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id) {
        return accountService
                .findAccountById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("findByPhone/{phoneNumber}")
    public ResponseEntity<CustomerDTO> getAccountByPhoneNumber(
            @PathVariable
                    @Pattern(
                            regexp = "(^$|[0-9]{10})",
                            message = "Phone Number number must be 10 digits")
                    String phoneNumber) {
        CustomerDTO customerDto = accountService.fetchAccount(phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountsMSReponseDTO> createAccount(
            @Valid @RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new AccountsMSReponseDTO(
                                AcoountMSConstants.STATUS_201, AcoountMSConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<AccountsMSReponseDTO> updateAccount(
            @Valid @RequestBody CustomerDTO customerDto) {
        boolean isUpdated = accountService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new AccountsMSReponseDTO(
                                    AcoountMSConstants.STATUS_200, AcoountMSConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            new AccountsMSReponseDTO(
                                    AcoountMSConstants.STATUS_417,
                                    AcoountMSConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/{phoneNumber}")
    public ResponseEntity<AccountsMSReponseDTO> deleteAccount(
            @PathVariable
                    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
                    String phoneNumber) {
        boolean isDeleted = accountService.deleteAccount(phoneNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new AccountsMSReponseDTO(
                                    AcoountMSConstants.STATUS_200, AcoountMSConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            new AccountsMSReponseDTO(
                                    AcoountMSConstants.STATUS_417,
                                    AcoountMSConstants.MESSAGE_417_DELETE));
        }
    }
}
