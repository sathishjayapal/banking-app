package me.sathish.bank.controllers;

import me.sathish.bank.common.AbstractIntegrationTest;

class AccountsControllerIT extends AbstractIntegrationTest {

    //    @Autowired private AccountRepository accountRepository;
    //
    //    private List<Accounts> accountsList = null;
    //
    //    @BeforeEach
    //    void setUp() {
    //        accountRepository.deleteAllInBatch();
    //
    //        accountsList = new ArrayList<>();
    //        accountsList.add(new Accounts(null, "First Accounts"));
    //        accountsList.add(new Accounts(null, "Second Accounts"));
    //        accountsList.add(new Accounts(null, "Third Accounts"));
    //        accountsList = accountRepository.saveAll(accountsList);
    //    }
    //
    //    @Test
    //    void shouldFetchAllAccounts() throws Exception {
    //        this.mockMvc
    //                .perform(get("/api/accounts"))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.data.size()", is(accountsList.size())))
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
    //    void shouldFindAccountById() throws Exception {
    //        Accounts accounts = accountsList.get(0);
    //        Long accountId = accounts.getId();
    //
    //        this.mockMvc
    //                .perform(get("/api/accounts/{id}", accountId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(accounts.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(accounts.getText())));
    //    }
    //
    //    @Test
    //    void shouldCreateNewAccount() throws Exception {
    //        Accounts accounts = new Accounts(null, "New Accounts");
    //        this.mockMvc
    //                .perform(
    //                        post("/api/accounts")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(accounts)))
    //                .andExpect(status().isCreated())
    //                .andExpect(jsonPath("$.id", notNullValue()))
    //                .andExpect(jsonPath("$.text", is(accounts.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn400WhenCreateNewAccountWithoutText() throws Exception {
    //        Accounts accounts = new Accounts(null, null);
    //
    //        this.mockMvc
    //                .perform(
    //                        post("/api/accounts")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(accounts)))
    //                .andExpect(status().isBadRequest())
    //                .andExpect(header().string("Content-Type", is("application/problem+json")))
    //                .andExpect(jsonPath("$.type", is("about:blank")))
    //                .andExpect(jsonPath("$.title", is("Constraint Violation")))
    //                .andExpect(jsonPath("$.status", is(400)))
    //                .andExpect(jsonPath("$.detail", is("Invalid request content.")))
    //                .andExpect(jsonPath("$.instance", is("/api/accounts")))
    //                .andExpect(jsonPath("$.violations", hasSize(1)))
    //                .andExpect(jsonPath("$.violations[0].field", is("text")))
    //                .andExpect(jsonPath("$.violations[0].message", is("Text cannot be empty")))
    //                .andReturn();
    //    }
    //
    //    @Test
    //    void shouldUpdateAccount() throws Exception {
    //        Accounts accounts = accountsList.get(0);
    //        accounts.setText("Updated Accounts");
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/accounts/{id}", accounts.getId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(accounts)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(accounts.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(accounts.getText())));
    //    }
    //
    //    @Test
    //    void shouldDeleteAccount() throws Exception {
    //        Accounts accounts = accountsList.get(0);
    //
    //        this.mockMvc
    //                .perform(delete("/api/accounts/{id}", accounts.getId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(accounts.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(accounts.getText())));
    //    }
}
