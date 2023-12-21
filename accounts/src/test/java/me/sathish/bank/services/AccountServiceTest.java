package me.sathish.bank.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.List;
import me.sathish.bank.entities.Accounts;
import me.sathish.bank.repositories.AccountRepository;
import me.sathish.bank.response.PagedResult;
import me.sathish.bank.utils.AppConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock private AccountRepository accountRepository;

    @InjectMocks private AccountService accountService;

    @Test
    void findAllAccounts() {
        // given
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
        Page<Accounts> accountPage = new PageImpl<>(List.of(getAccount()));
        given(accountRepository.findAll(pageable)).willReturn(accountPage);

        // when
        PagedResult<Accounts> pagedResult = accountService.findAllAccounts(0, 10, "id", "asc");

        // then
        assertThat(pagedResult).isNotNull();
        assertThat(pagedResult.data()).isNotEmpty().hasSize(1);
        assertThat(pagedResult.hasNext()).isFalse();
        assertThat(pagedResult.pageNumber()).isEqualTo(1);
        assertThat(pagedResult.totalPages()).isEqualTo(1);
        assertThat(pagedResult.isFirst()).isTrue();
        assertThat(pagedResult.isLast()).isTrue();
        assertThat(pagedResult.hasPrevious()).isFalse();
        assertThat(pagedResult.totalElements()).isEqualTo(1);
    }

    //    @Test
    //    void findAccountById() {
    //        // given
    //        given(accountRepository.findById(1L)).willReturn(Optional.of(getAccount()));
    //        // when
    //        Optional<Accounts> optionalAccount = accountService.findAccountById(1L);
    //        // then
    //        assertThat(optionalAccount).isPresent();
    //        Accounts accounts = optionalAccount.get();
    //        assertThat(accounts.getId()).isEqualTo(1L);
    //        assertThat(accounts.getText()).isEqualTo("junitTest");
    //    }

    //    @Test
    //    void saveAccount() {
    //        // given
    //        given(accountRepository.save(getAccount())).willReturn(getAccount());
    //        // when
    //        Accounts persistedAccounts = accountService.createAccount(getAccount());
    //        // then
    //        assertThat(persistedAccounts).isNotNull();
    //        assertThat(persistedAccounts.getId()).isEqualTo(1L);
    //        assertThat(persistedAccounts.getText()).isEqualTo("junitTest");
    //    }

    @Test
    void deleteAccountById() {
        // given
        willDoNothing().given(accountRepository).deleteById(1L);
        // when
        accountService.deleteAccountById(1L);
        // then
        verify(accountRepository, times(1)).deleteById(1L);
    }

    private Accounts getAccount() {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(1L);
        accounts.setBankAddress(AppConstants.ADDRESS);
        accounts.setCustomerId(1L);
        accounts.setAccountType(AppConstants.SAVINGS);
        return accounts;
    }
}
