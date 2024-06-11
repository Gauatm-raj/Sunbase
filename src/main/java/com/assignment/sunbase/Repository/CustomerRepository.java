package com.assignment.sunbase.Repository;

import com.assignment.sunbase.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer>
    findAllByFirstNameContainingOrLastNameContaining(String firstName,
                                                     String lastName, Pageable pageable);

    public Customer findByEmail(String email);
}
