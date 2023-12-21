package me.sathish.bank.controllers;

import me.sathish.bank.common.AbstractIntegrationTest;

class CustomerControllerIT extends AbstractIntegrationTest {

    //    @Autowired private CustomerRepository customerRepository;
    //
    //    private List<Customer> customerList = null;
    //
    //    @BeforeEach
    //    void setUp() {
    //        customerRepository.deleteAllInBatch();
    //
    //        customerList = new ArrayList<>();
    //        customerList.add(new Customer(null, "First Customer"));
    //        customerList.add(new Customer(null, "Second Customer"));
    //        customerList.add(new Customer(null, "Third Customer"));
    //        customerList = customerRepository.saveAll(customerList);
    //    }
    //
    //    @Test
    //    void shouldFetchAllCustomers() throws Exception {
    //        this.mockMvc
    //                .perform(get("/api/customers"))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.data.size()", is(customerList.size())))
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
    //    void shouldFindCustomerById() throws Exception {
    //        Customer customer = customerList.get(0);
    //        Long customerId = customer.getId();
    //
    //        this.mockMvc
    //                .perform(get("/api/customers/{id}", customerId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(customer.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(customer.getText())));
    //    }
    //
    //    @Test
    //    void shouldCreateNewCustomer() throws Exception {
    //        Customer customer = new Customer(null, "New Customer");
    //        this.mockMvc
    //                .perform(
    //                        post("/api/customers")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(customer)))
    //                .andExpect(status().isCreated())
    //                .andExpect(jsonPath("$.id", notNullValue()))
    //                .andExpect(jsonPath("$.text", is(customer.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn400WhenCreateNewCustomerWithoutText() throws Exception {
    //        Customer customer = new Customer(null, null);
    //
    //        this.mockMvc
    //                .perform(
    //                        post("/api/customers")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(customer)))
    //                .andExpect(status().isBadRequest())
    //                .andExpect(header().string("Content-Type", is("application/problem+json")))
    //                .andExpect(jsonPath("$.type", is("about:blank")))
    //                .andExpect(jsonPath("$.title", is("Constraint Violation")))
    //                .andExpect(jsonPath("$.status", is(400)))
    //                .andExpect(jsonPath("$.detail", is("Invalid request content.")))
    //                .andExpect(jsonPath("$.instance", is("/api/customers")))
    //                .andExpect(jsonPath("$.violations", hasSize(1)))
    //                .andExpect(jsonPath("$.violations[0].field", is("text")))
    //                .andExpect(jsonPath("$.violations[0].message", is("Text cannot be empty")))
    //                .andReturn();
    //    }
    //
    //    @Test
    //    void shouldUpdateCustomer() throws Exception {
    //        Customer customer = customerList.get(0);
    //        customer.setText("Updated Customer");
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/customers/{id}", customer.getId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(customer)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(customer.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(customer.getText())));
    //    }
    //
    //    @Test
    //    void shouldDeleteCustomer() throws Exception {
    //        Customer customer = customerList.get(0);
    //
    //        this.mockMvc
    //                .perform(delete("/api/customers/{id}", customer.getId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(customer.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(customer.getText())));
    //    }
}
