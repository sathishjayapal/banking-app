package me.sathish.bank.controllers;

import lombok.extern.slf4j.Slf4j;
import me.sathish.bank.dto.AccountsDTO;
import me.sathish.bank.dto.AccountsMSReponseDTO;
import me.sathish.bank.dto.CustomerDTO;
import me.sathish.bank.entities.Accounts;
import me.sathish.bank.mapper.AccountsMapper;
import me.sathish.bank.response.PagedResult;
import me.sathish.bank.services.AccountService;
import me.sathish.bank.utils.AppConstants;
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
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public PagedResult<Accounts> getAllAccounts(
            @RequestParam(
                            value = "pageNo",
                            defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,
                            required = false)
                    int pageNo,
            @RequestParam(
                            value = "pageSize",
                            defaultValue = AppConstants.DEFAULT_PAGE_SIZE,
                            required = false)
                    int pageSize,
            @RequestParam(
                            value = "sortBy",
                            defaultValue = AppConstants.DEFAULT_SORT_BY,
                            required = false)
                    String sortBy,
            @RequestParam(
                            value = "sortDir",
                            defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountsMSReponseDTO> createAccount(
            @RequestBody @Validated CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AccountsMSReponseDTO(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accounts> updateAccount(
            @PathVariable Long id, @RequestBody Accounts accounts) {
        AccountsDTO accountsDTO = new AccountsDTO();
        AccountsMapper.mapToAccountsDto(accounts, accountsDTO);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAccountsDto(accountsDTO);
        customerDTO.setName("Sathish Jayapal");

        return accountService
                .findAccountById(id)
                .map(
                        accountObj -> {
                            accounts.setAccountNumber(id);
                            return ResponseEntity.ok(accounts);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Accounts> deleteAccount(@PathVariable Long id) {
        return accountService
                .findAccountById(id)
                .map(
                        account -> {
                            accountService.deleteAccountById(id);
                            return ResponseEntity.ok(account);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
