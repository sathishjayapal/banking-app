package me.sathish.loans.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {
    //
    //    @Mock private LoanRepository loanRepository;
    //
    //    @InjectMocks private LoanService loanService;

    //    @Test
    //    void findAllLoans() {
    //        // given
    //        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
    //        Page<Loan> loanPage = new PageImpl<>(List.of(getLoan()));
    //        given(loanRepository.findAll(pageable)).willReturn(loanPage);
    //
    //        // when
    //        PagedResult<Loan> pagedResult = loanService.findAllLoans(0, 10, "id", "asc");
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
    //    void findLoanById() {
    //        // given
    //        given(loanRepository.findById(1L)).willReturn(Optional.of(getLoan()));
    //        // when
    //        Optional<Loan> optionalLoan = loanService.findLoanById(1L);
    //        // then
    //        assertThat(optionalLoan).isPresent();
    //        Loan loan = optionalLoan.get();
    //        assertThat(loan.getLoanId()).isEqualTo(1L);
    //        assertThat(loan.getPhoneNumber()).isEqualTo("junitTest");
    //    }

    //    @Test
    //    void saveLoan() {
    //        // given
    //        given(loanRepository.save(getLoan())).willReturn(getLoan());
    //        // when
    //        Loan persistedLoan = loanService.saveLoan(getLoan());
    //        // then
    //        assertThat(persistedLoan).isNotNull();
    //        assertThat(persistedLoan.getLoanId()).isEqualTo(1L);
    //        assertThat(persistedLoan.getPhoneNumber()).isEqualTo("junitTest");
    //    }

    //    @Test
    //    void deleteLoanById() {
    //        // given
    //        willDoNothing().given(loanRepository).deleteById(1L);
    //        // when
    //        loanService.deleteLoanById(1L);
    //        // then
    //        verify(loanRepository, times(1)).deleteById(1L);
    //    }

    //    private Loan getLoan() {
    //        Loan loan = new Loan();
    //        loan.setLoanId(1L);
    //        loan.setPhoneNumber("junitTest");
    //        return loan;
    //    }
}
