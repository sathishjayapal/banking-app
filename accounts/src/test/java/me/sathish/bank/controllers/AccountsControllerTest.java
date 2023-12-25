package me.sathish.bank.controllers;

import static me.sathish.bank.utils.AcoountMSConstants.PROFILE_TEST;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

@WebMvcTest(controllers = AccountController.class)
@ActiveProfiles(PROFILE_TEST)
class AccountsControllerTest {

    //    @Autowired private MockMvc mockMvc;
    //
    //    @MockBean private AccountService accountService;
    //
    //    @Autowired private ObjectMapper objectMapper;
    //
    //    private List<Accounts> accountsList;
    //    Faker faker = Faker.instance();
    //
    //    @BeforeEach
    //    void setUp() {
    //        this.accountsList = new ArrayList<>();
    //        this.accountsList.add(
    //                new Accounts(
    //                        faker.random().nextLong(),
    //                        1L,
    //                        AcoountMSConstants.SAVINGS,
    //                        AcoountMSConstants.ADDRESS));
    //        this.accountsList.add(
    //                new Accounts(
    //                        faker.random().nextLong(),
    //                        2L,
    //                        AcoountMSConstants.SAVINGS,
    //                        AcoountMSConstants.ADDRESS));
    //        this.accountsList.add(
    //                new Accounts(
    //                        faker.random().nextLong(),
    //                        3L,
    //                        AcoountMSConstants.SAVINGS,
    //                        AcoountMSConstants.ADDRESS));
    //    }
    //
    //    @Test
    //    void shouldFetchAllAccounts() throws Exception {
    //        Page<Accounts> page = new PageImpl<>(accountsList);
    //        PagedResult<Accounts> accountPagedResult = new PagedResult<>(page);
    //        given(accountService.findAllAccounts(0, 10, "id",
    // "asc")).willReturn(accountPagedResult);
    //
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
    //        Long accountId = 1L;
    //        Accounts accounts =
    //                new Accounts(
    //                        faker.random().nextLong(),
    //                        1L,
    //                        AcoountMSConstants.SAVINGS,
    //                        AcoountMSConstants.ADDRESS);
    //        given(accountService.findAccountById(accountId)).willReturn(Optional.of(accounts));
    //
    //        this.mockMvc
    //                .perform(get("/api/accounts/{id}", accountId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.account_type", is(accounts.getBankAddress())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenFetchingNonExistingAccount() throws Exception {
    //        Long accountId = 1L;
    //        given(accountService.findAccountById(accountId)).willReturn(Optional.empty());
    //
    //        this.mockMvc.perform(get("/api/accounts/{id}",
    // accountId)).andExpect(status().isNotFound());
    //    }

    //    @Test
    //    void shouldCreateNewAccount() throws Exception {
    //        given(accountService.createAccount(any(CustomerDTO.class)))
    //                .willAnswer((invocation) -> invocation.getArgument(0));
    //        this.mockMvc
    //                .perform(
    //                        post("/api/accounts")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(customerDTO)))
    //                .andExpect(status().isCreated());
    //                .andExpect(jsonPath("$.errorCode", notNullValue()))
    //                .andExpect(jsonPath("$.errorString", is(accounts.getText())));
    //    }

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

    //    @Test
    //    void shouldUpdateAccount() throws Exception {
    //        Long accountId = 1L;
    //        Accounts accounts = new Accounts(accountId, "Updated text");
    //        given(accountService.findAccountById(accountId)).willReturn(Optional.of(accounts));
    //        given(accountService.createAccount(any(Accounts.class)))
    //                .willAnswer((invocation) -> invocation.getArgument(0));
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/accounts/{id}", accounts.getId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(accounts)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(accounts.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenUpdatingNonExistingAccount() throws Exception {
    //        Long accountId = 1L;
    //        given(accountService.findAccountById(accountId)).willReturn(Optional.empty());
    //        Accounts accounts = new Accounts(accountId, "Updated text");
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/accounts/{id}", accountId)
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(accounts)))
    //                .andExpect(status().isNotFound());
    //    }
    //
    //    @Test
    //    void shouldDeleteAccount() throws Exception {
    //        Long accountId = 1L;
    //        Accounts accounts = new Accounts(accountId, "Some text");
    //        given(accountService.findAccountById(accountId)).willReturn(Optional.of(accounts));
    //        doNothing().when(accountService).deleteAccountById(accounts.getId());
    //
    //        this.mockMvc
    //                .perform(delete("/api/accounts/{id}", accounts.getId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(accounts.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenDeletingNonExistingAccount() throws Exception {
    //        Long accountId = 1L;
    //        given(accountService.findAccountById(accountId)).willReturn(Optional.empty());
    //
    //        this.mockMvc
    //                .perform(delete("/api/accounts/{id}", accountId))
    //                .andExpect(status().isNotFound());
    //    }
}
