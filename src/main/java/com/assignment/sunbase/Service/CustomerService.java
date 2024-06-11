package com.assignment.sunbase.Service;

import com.assignment.sunbase.Model.Customer;
import com.assignment.sunbase.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer =
                customerRepository.findById(id).orElseThrow(() -> new
                        RuntimeException("Customer not found"));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setStreet(customer.getStreet());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        return customerRepository.save(existingCustomer);
    }
    public Page<Customer> getCustomers(Pageable pageable, String
            search) {
        if (search != null && !search.isEmpty()) {
            return
                    customerRepository.findAllByFirstNameContainingOrLastNameContaining(search, search, pageable);
        }
        return customerRepository.findAll(pageable);
    }
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
