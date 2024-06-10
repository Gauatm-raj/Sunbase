package com.assignment.sunbase.Service;

import com.assignment.sunbase.Model.Customer;
import com.assignment.sunbase.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        Optional<Customer> existingCustomer = Optional.ofNullable(customerRepository.findByEmail(customer.getEmail()));
        if (existingCustomer.isPresent()) {
            customer.setId(existingCustomer.get().getId());
        }
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Page<Customer> findAll(int page, int size, String sortField, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size);
        return customerRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}

