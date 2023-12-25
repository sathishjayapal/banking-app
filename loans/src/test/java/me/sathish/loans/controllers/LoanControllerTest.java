package me.sathish.loans.controllers;

import static me.sathish.loans.utils.LoanMSConstants.PROFILE_TEST;

import java.util.ArrayList;
import java.util.List;
import me.sathish.loans.entities.Loan;
import me.sathish.loans.utils.LoanMSConstants;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

@WebMvcTest(controllers = LoanController.class)
@ActiveProfiles(PROFILE_TEST)
class LoanControllerTest {

    //    @Autowired private MockMvc mockMvc;
    //
    //    @MockBean private LoanService loanService;
    //
    //    @Autowired private ObjectMapper objectMapper;

    private List<Loan> loanList;

    @BeforeEach
    void setUp() {
        this.loanList = new ArrayList<>();
        this.loanList.add(
                new Loan(
                        1L,
                        "6082424100",
                        "1L",
                        LoanMSConstants.HOME_LOAN,
                        LoanMSConstants.NEW_LOAN_LIMIT,
                        0,
                        0));
        this.loanList.add(
                new Loan(
                        2L,
                        "6082424101",
                        "2L",
                        LoanMSConstants.HOME_LOAN,
                        LoanMSConstants.NEW_LOAN_LIMIT,
                        0,
                        0));
        this.loanList.add(
                new Loan(
                        3L,
                        "6082424102",
                        "3L",
                        LoanMSConstants.HOME_LOAN,
                        LoanMSConstants.NEW_LOAN_LIMIT,
                        0,
                        0));
    }

    //    @Test
    //    void shouldFetchAllLoans() throws Exception {
    //        Page<Loan> page = new PageImpl<>(loanList);
    //        PagedResult<Loan> loanPagedResult = new PagedResult<>(page);
    //        given(loanService.findAllLoans(0, 10, "id", "asc")).willReturn(loanPagedResult);
    //
    //        this.mockMvc
    //                .perform(get("/api/loans"))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.data.size()", is(loanList.size())))
    //                .andExpect(jsonPath("$.totalElements", is(3)))
    //                .andExpect(jsonPath("$.pageNumber", is(1)))
    //                .andExpect(jsonPath("$.totalPages", is(1)))
    //                .andExpect(jsonPath("$.isFirst", is(true)))
    //                .andExpect(jsonPath("$.isLast", is(true)))
    //                .andExpect(jsonPath("$.hasNext", is(false)))
    //                .andExpect(jsonPath("$.hasPrevious", is(false)));
    //    }
    //
    //    @Test
    //    void shouldFindLoanById() throws Exception {
    //        Long loanId = 1L;
    //        Loan loan =
    //                new Loan(
    //                        1L,
    //                        "6082424100",
    //                        "1L",
    //                        LoanMSConstants.HOME_LOAN,
    //                        LoanMSConstants.NEW_LOAN_LIMIT,
    //                        0,
    //                        0);
    //        given(loanService.findLoanById(loanId)).willReturn(Optional.of(loan));
    //
    //        this.mockMvc
    //                .perform(get("/api/loans/{id}", loanId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenFetchingNonExistingLoan() throws Exception {
    //        Long loanId = 1L;
    //        given(loanService.findLoanById(loanId)).willReturn(Optional.empty());
    //
    //        this.mockMvc.perform(get("/api/loans/{id}", loanId)).andExpect(status().isNotFound());
    //    }

    //    @Test
    //    void shouldCreateNewLoan() throws Exception {
    //        given(loanService.saveLoan(any(LoanDTO.class)))
    //                .willAnswer((invocation) -> invocation.getArgument(0));
    //
    //        Loan loan =
    //                new Loan(
    //                        1L,
    //                        "6082424100",
    //                        "1L",
    //                        LoanMSConstants.HOME_LOAN,
    //                        LoanMSConstants.NEW_LOAN_LIMIT,
    //                        0,
    //                        0);
    //        this.mockMvc
    //                .perform(
    //                        post("/api/loans")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(loan)))
    //                .andExpect(status().isCreated())
    //                .andExpect(jsonPath("$.id", notNullValue()))
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }

    //    @Test
    //    void shouldReturn400WhenCreateNewLoanWithoutText() throws Exception {
    //        Loan loan =
    //                new Loan(
    //                        1L,
    //                        "6082424100",
    //                        "1L",
    //                        LoanMSConstants.HOME_LOAN,
    //                        LoanMSConstants.NEW_LOAN_LIMIT,
    //                        0,
    //                        0);
    //
    //        this.mockMvc
    //                .perform(
    //                        post("/api/loans")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(loan)))
    //                .andExpect(status().isBadRequest())
    //                .andExpect(header().string("Content-Type", is("application/problem+json")))
    //                .andExpect(jsonPath("$.type", is("about:blank")))
    //                .andExpect(jsonPath("$.title", is("Constraint Violation")))
    //                .andExpect(jsonPath("$.status", is(400)))
    //                .andExpect(jsonPath("$.detail", is("Invalid request content.")))
    //                .andExpect(jsonPath("$.instance", is("/api/loans")))
    //                .andExpect(jsonPath("$.violations", hasSize(1)))
    //                .andExpect(jsonPath("$.violations[0].field", is("text")))
    //                .andExpect(jsonPath("$.violations[0].message", is("Text cannot be empty")))
    //                .andReturn();
    //    }

    //    @Test
    //    void shouldUpdateLoan() throws Exception {
    //        Long loanId = 1L;
    //        Loan loan =
    //                new Loan(
    //                        1L,
    //                        "6082424100",
    //                        "1L",
    //                        LoanMSConstants.HOME_LOAN,
    //                        LoanMSConstants.NEW_LOAN_LIMIT,
    //                        0,
    //                        0);
    //        given(loanService.findLoanById(loanId)).willReturn(Optional.of(loan));
    //        given(loanService.saveLoan(any(LoanDTO.class)))
    //                .willAnswer((invocation) -> invocation.getArgument(0));
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/loans/{id}", loan.getLoanId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(loan)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }

    //    @Test
    //    void shouldReturn404WhenUpdatingNonExistingLoan() throws Exception {
    //        Long loanId = 1L;
    //        given(loanService.findLoanById(loanId)).willReturn(Optional.empty());
    //        Loan loan =
    //                new Loan(
    //                        1L,
    //                        "6082424100",
    //                        "1L",
    //                        LoanMSConstants.HOME_LOAN,
    //                        LoanMSConstants.NEW_LOAN_LIMIT,
    //                        0,
    //                        0);
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/loans/{id}", loanId)
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(loan)))
    //                .andExpect(status().isNotFound());
    //    }

    //    @Test
    //    void shouldDeleteLoan() throws Exception {
    //        Long loanId = 1L;
    //        Loan loan =
    //                new Loan(
    //                        1L,
    //                        "6082424100",
    //                        "1L",
    //                        LoanMSConstants.HOME_LOAN,
    //                        LoanMSConstants.NEW_LOAN_LIMIT,
    //                        0,
    //                        0);
    //        given(loanService.findLoanById(loanId)).willReturn(Optional.of(loan));
    //        doNothing().when(loanService).deleteLoanById(loan.getLoanId());
    //
    //        this.mockMvc
    //                .perform(delete("/api/loans/{id}", loan.getLoanId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }

    //    @Test
    //    void shouldReturn404WhenDeletingNonExistingLoan() throws Exception {
    //        Long loanId = 1L;
    //        given(loanService.findLoanById(loanId)).willReturn(Optional.empty());
    //
    //        this.mockMvc.perform(delete("/api/loans/{id}",
    // loanId)).andExpect(status().isNotFound());
    //    }
}
