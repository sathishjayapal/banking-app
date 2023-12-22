package me.sathish.bank.services;

import java.util.Optional;
import me.sathish.bank.dto.CustomerDTO;
import me.sathish.bank.entities.Customer;
import me.sathish.bank.exception.CustomerExistsException;
import me.sathish.bank.exception.ResourceNotFoundException;
import me.sathish.bank.mapper.CustomerMapper;
import me.sathish.bank.repositories.CustomerRepository;
import me.sathish.bank.response.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public PagedResult<Customer> findAllCustomers(
            int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort =
                sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Customer> customersPage = customerRepository.findAll(pageable);

        return new PagedResult<>(customersPage);
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    public Customer saveCustomerFromDTO(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer =
                customerRepository.findByPhoneNumber(customerDTO.getPhoneNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerExistsException(
                    "Customer already registered with given mobileNumber "
                            + customerDTO.getPhoneNumber());
        }
        customer = customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Long customerID, CustomerDTO customerDto) {
        Customer customer =
                customerRepository
                        .findById(customerID)
                        .orElseThrow(
                                () ->
                                        new ResourceNotFoundException(
                                                "Customer", "CustomerID", customerID.toString()));
        CustomerMapper.mapToCustomer(customerDto, customer);
        return customerRepository.save(customer);
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Customer", "Phone Number", phoneNumber));
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
