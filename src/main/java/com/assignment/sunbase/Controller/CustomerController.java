package com.assignment.sunbase.Controller;

import com.assignment.sunbase.Model.Customer;
import com.assignment.sunbase.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody
    Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
    @GetMapping
    public Page<Customer> getAllCustomers(@RequestParam
                                          Optional<String> search,
                                          @RequestParam
                                          Optional<Integer> page,
                                          @RequestParam
                                          Optional<Integer> size) {
        Pageable pageable = PageRequest.of(page.orElse(0),
                size.orElse(10));
        return customerService.getCustomers(pageable,
                search.orElse(""));
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id).orElseThrow(() ->
                new RuntimeException("Customer not found"));
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}

