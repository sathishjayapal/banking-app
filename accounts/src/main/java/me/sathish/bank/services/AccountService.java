package me.sathish.bank.services;

import java.util.Optional;
import java.util.Random;
import me.sathish.bank.dto.AccountsDTO;
import me.sathish.bank.dto.CustomerDTO;
import me.sathish.bank.entities.Accounts;
import me.sathish.bank.entities.Customer;
import me.sathish.bank.exception.ResourceNotFoundException;
import me.sathish.bank.mapper.AccountsMapper;
import me.sathish.bank.mapper.CustomerMapper;
import me.sathish.bank.repositories.AccountRepository;
import me.sathish.bank.response.PagedResult;
import me.sathish.bank.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public PagedResult<Accounts> findAllAccounts(
            int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort =
                sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Accounts> accountsPage = accountRepository.findAll(pageable);

        return new PagedResult<>(accountsPage);
    }

    public Optional<Accounts> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Accounts> findByCustomerID(Long customerID) {
        return accountRepository.findByCustomerId(customerID);
    }

    public AccountsDTO createAccount(CustomerDTO customerDTO) {
        Customer customer = customerService.saveCustomerFromDTO(customerDTO);
        Accounts postSavedAcnt = accountRepository.save(createNewAccount(customer));
        return AccountsMapper.mapToAccountsDto(postSavedAcnt, new AccountsDTO());
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AppConstants.SAVINGS);
        newAccount.setBankAddress(AppConstants.ADDRESS);
        return newAccount;
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public boolean updateAccount(CustomerDTO customerDto) {
        boolean isUpdated = false;
        AccountsDTO accountsDto = customerDto.getAccountsDto();
        if (accountsDto != null) {
            Accounts accounts =
                    accountRepository
                            .findById(accountsDto.getAccountNumber())
                            .orElseThrow(
                                    () ->
                                            new ResourceNotFoundException(
                                                    "Account",
                                                    "AccountNumber",
                                                    accountsDto.getAccountNumber().toString()));
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountRepository.save(accounts);
            customerService.updateCustomer(accounts.getCustomerId(), customerDto);
            isUpdated = true;
        }
        return isUpdated;
    }

    public CustomerDTO fetchAccount(String phoneNumber) {
        Customer customer = customerService.findCustomerByPhoneNumber(phoneNumber);
        Accounts accounts =
                accountRepository
                        .findByCustomerId(customer.getCustomerId())
                        .orElseThrow(
                                () ->
                                        new ResourceNotFoundException(
                                                "Account",
                                                "customerId",
                                                customer.getCustomerId().toString()));
        CustomerDTO customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));
        return customerDto;
    }
    /**
     * @param phoneNumber - Input Customer Phone Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    public boolean deleteAccount(String phoneNumber) {
        Customer customer = customerService.findCustomerByPhoneNumber(phoneNumber);
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerService.deleteCustomerById(customer.getCustomerId());
        return true;
    }
}
