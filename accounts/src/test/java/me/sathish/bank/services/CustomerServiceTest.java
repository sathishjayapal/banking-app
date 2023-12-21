package me.sathish.bank.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    //
    //    @Mock private CustomerRepository customerRepository;
    //
    //    @InjectMocks private CustomerService customerService;
    //
    //    @Test
    //    void findAllCustomers() {
    //        // given
    //        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
    //        Page<Customer> customerPage = new PageImpl<>(List.of(getCustomer()));
    //        given(customerRepository.findAll(pageable)).willReturn(customerPage);
    //
    //        // when
    //        PagedResult<Customer> pagedResult = customerService.findAllCustomers(0, 10, "id",
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
    //    void findCustomerById() {
    //        // given
    //        given(customerRepository.findById(1L)).willReturn(Optional.of(getCustomer()));
    //        // when
    //        Optional<Customer> optionalCustomer = customerService.findCustomerById(1L);
    //        // then
    //        assertThat(optionalCustomer).isPresent();
    //        Customer customer = optionalCustomer.get();
    //        assertThat(customer.getId()).isEqualTo(1L);
    //        assertThat(customer.getText()).isEqualTo("junitTest");
    //    }
    //
    //    @Test
    //    void saveCustomer() {
    //        // given
    //        given(customerRepository.save(getCustomer())).willReturn(getCustomer());
    //        // when
    //        Customer persistedCustomer = customerService.saveCustomer(getCustomer());
    //        // then
    //        assertThat(persistedCustomer).isNotNull();
    //        assertThat(persistedCustomer.getId()).isEqualTo(1L);
    //        assertThat(persistedCustomer.getText()).isEqualTo("junitTest");
    //    }
    //
    //    @Test
    //    void deleteCustomerById() {
    //        // given
    //        willDoNothing().given(customerRepository).deleteById(1L);
    //        // when
    //        customerService.deleteCustomerById(1L);
    //        // then
    //        verify(customerRepository, times(1)).deleteById(1L);
    //    }
    //
    //    private Customer getCustomer() {
    //        Customer customer = new Customer();
    //        customer.setId(1L);
    //        customer.setText("junitTest");
    //        return customer;
    //    }
}
