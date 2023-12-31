package me.sathish.bank.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    //    @Mock private AccountRepository accountRepository;
    //    @Mock private CustomerService customerService;
    //    Faker faker = Faker.instance();
    //    @InjectMocks private AccountService accountService;
    //
    //    @Test
    //    void findAllAccounts() {
    //        // given
    //        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
    //        Page<Accounts> accountPage = new PageImpl<>(List.of(getAccount()));
    //        given(accountRepository.findAll(pageable)).willReturn(accountPage);
    //
    //        // when
    //        PagedResult<Accounts> pagedResult = accountService.findAllAccounts(0, 10, "id",
    // "asc");
    //
    //        // then
    //        assertThat(pagedResult).isNotNull();
    //        assertThat(pagedResult.data()).isNotEmpty().hasSize(1);
    //        assertThat(pagedResult.hasNext()).isFalse();
    //        assertThat(pagedResult.pageNumber()).isEqualTo(1);
    //        assertThat(pagedResult.totalPages()).isEqualTo(1);
    //        assertThat(pagedResult.isFirst()).isTrue();
    //        assertThat(pagedResult.isLast()).isTrue();
    //        assertThat(pagedResult.hasPrevious()).isFalse();
    //        assertThat(pagedResult.totalElements()).isEqualTo(1);
    //    }
    //
    //    @Test
    //    void findAccountById() {
    //        // given
    //        given(accountRepository.findById(1L)).willReturn(Optional.of(getAccount()));
    //        // when
    //        Optional<Accounts> optionalAccount = accountService.findAccountById(1L);
    //        // then
    //        assertThat(optionalAccount).isPresent();
    //        Accounts accounts = optionalAccount.get();
    //        assertThat(accounts.getAccountNumber()).isEqualTo(1L);
    //        assertThat(accounts.getBankAddress()).isEqualTo(AcoountMSConstants.ADDRESS);
    //    }
    //
    //    @Test
    //    void findAccountByCustomerID() {
    //        // given
    //        given(accountRepository.findByCustomerId(1L)).willReturn(Optional.of(getAccount()));
    //        // when
    //        Optional<Accounts> optionalAccount = accountService.findByCustomerID(1L);
    //        // then
    //        assertThat(optionalAccount).isPresent();
    //        Accounts accounts = optionalAccount.get();
    //        assertThat(accounts.getAccountNumber()).isEqualTo(1L);
    //        assertThat(accounts.getCustomerId()).isEqualTo(1L);
    //    }
    //
    //    @Test
    //    void createAccount() {
    //        CustomerDTO customerDTO = getCustomerDTO();
    //        AccountsDTO accountsDTO = accountService.createAccount(customerDTO);
    //        // then
    //        assertThat(accountsDTO).isNotNull();
    //        assertThat(accountsDTO.getAccountType()).isEqualTo(AcoountMSConstants.SAVINGS);
    //    }
    //
    //    @Test
    //    void deleteAccountById() {
    //        // given
    //        willDoNothing().given(accountRepository).deleteById(1L);
    //        // when
    //        accountService.deleteAccountById(1L);
    //        // then
    //        verify(accountRepository, times(1)).deleteById(1L);
    //    }
    //
    //    private Accounts getAccount() {
    //        Accounts accounts = new Accounts();
    //        accounts.setAccountNumber(1L);
    //        accounts.setBankAddress(AcoountMSConstants.ADDRESS);
    //        accounts.setCustomerId(1L);
    //        accounts.setAccountType(AcoountMSConstants.SAVINGS);
    //        return accounts;
    //    }
    //
    //    private AccountsDTO getAccountsDTO() {
    //        AccountsDTO accountsDTO = new AccountsDTO();
    //        CustomerDTO customerDTO = getCustomerDTO();
    //        accountsDTO.setAccountNumber(customerDTO.getAccountsDto().getAccountNumber());
    //        accountsDTO.setAccountType(customerDTO.getAccountsDto().getAccountType());
    //        accountsDTO.setBankAddress(customerDTO.getAccountsDto().getBankAddress());
    //        return accountsDTO;
    //    }
    //
    //    private CustomerDTO getCustomerDTO() {
    //        CustomerDTO customerDTO = new CustomerDTO();
    //        customerDTO.setName(faker.name().fullName());
    //        customerDTO.setPhoneNumber(faker.phoneNumber().phoneNumber());
    //        customerDTO.setEmail(faker.internet().emailAddress());
    //        AccountsDTO accountsDTO = new AccountsDTO();
    //        accountsDTO.setBankAddress(AcoountMSConstants.ADDRESS);
    //        accountsDTO.setAccountType(AcoountMSConstants.SAVINGS);
    //        accountsDTO.setAccountNumber(faker.random().nextLong());
    //        return customerDTO;
    //    }
}
