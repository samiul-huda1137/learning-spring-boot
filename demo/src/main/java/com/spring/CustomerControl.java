package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerControl {

    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (((Optional<?>) optionalCustomer).isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            if (customer.getName() != null) {
                existingCustomer.setName(customer.getName());
            }
            if (customer.getEmail() != null) {
                existingCustomer.setEmail(customer.getEmail());
            }
            if (customer.getAge() != null) {
                existingCustomer.setAge(customer.getAge());
            }
            Customer savedCustomer = customerRepository.save(existingCustomer);
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
