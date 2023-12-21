package me.sathish.bank.services;

import java.util.Optional;
import java.util.Random;
import me.sathish.bank.dto.CustomerDTO;
import me.sathish.bank.entities.Accounts;
import me.sathish.bank.entities.Customer;
import me.sathish.bank.exception.CustomerExistsException;
import me.sathish.bank.mapper.CustomerMapper;
import me.sathish.bank.repositories.AccountRepository;
import me.sathish.bank.repositories.CustomerRepository;
import me.sathish.bank.response.PagedResult;
import me.sathish.bank.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AccountService(
            AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public PagedResult<Accounts> findAllAccounts(
            int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort =
                sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Accounts> accountsPage = accountRepository.findAll(pageable);

        return new PagedResult<>(accountsPage);
    }

    public Optional<Accounts> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer =
                customerRepository.findByPhoneNumber(customerDTO.getPhoneNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerExistsException(
                    "Customer already registered with given mobileNumber "
                            + customerDTO.getPhoneNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
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
}
