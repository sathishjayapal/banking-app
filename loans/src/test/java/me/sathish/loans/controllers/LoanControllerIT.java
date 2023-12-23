package me.sathish.loans.controllers;

import me.sathish.loans.common.AbstractIntegrationTest;
import me.sathish.loans.entities.Loan;
import me.sathish.loans.utils.LoanMSConstants;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

class LoanControllerIT extends AbstractIntegrationTest {

    //    @Autowired private LoanRepository loanRepository;

    private List<Loan> loanList = null;

    @BeforeEach
    void setUp() {
        //        loanRepository.deleteAllInBatch();

        loanList = new ArrayList<>();
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

        //        loanList = loanRepository.saveAll(loanList);
    }

    //    @Test
    //    void shouldFetchAllLoans() throws Exception {
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
    //        Loan loan = loanList.get(0);
    //        Long loanId = loan.getLoanId();
    //
    //        this.mockMvc
    //                .perform(get("/api/loans/{id}", loanId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(loan.getLoanId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }

    //    @Test
    //    void shouldCreateNewLoan() throws Exception {
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
    //
    //    @Test
    //    void shouldUpdateLoan() throws Exception {
    //        Loan loan = loanList.get(0);
    //        loan.setPhoneNumber("Updated Loan");
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/loans/{id}", loan.getLoanId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(loan)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(loan.getLoanId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }
    //
    //    @Test
    //    void shouldDeleteLoan() throws Exception {
    //        Loan loan = loanList.get(0);
    //
    //        this.mockMvc
    //                .perform(delete("/api/loans/{id}", loan.getLoanId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(loan.getLoanId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(loan.getPhoneNumber())));
    //    }
}
