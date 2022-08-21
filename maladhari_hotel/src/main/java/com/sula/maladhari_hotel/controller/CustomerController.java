package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.dto.CustomerDTO;
import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.Customer;
import com.sula.maladhari_hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/")
    public List<Customer> getAllCustomers() throws ResourceNotFoundException {

        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No customers Are Available");
        }
    }

    /**
     * Create customer.
     *
     * @param customer the Customer
     * @return the customer
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@Valid @RequestBody Customer customer) throws ResourceAlreadyExisistException {
        Customer customer1=
                customerRepository
                        .findById(customer.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"Customer is already exists on :: " + customer.getId()));

        return customerRepository.save(customer);
    }

    /**
     * Update Customer response entity.
     *
     * @param customerId the Customer id
     * @param customerDetails the Customer details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable(value = "id") int customerId, @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer1=
                customerRepository
                        .findById(customerId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Customer not found on :: " + customerId));

        customer1.setName(customerDetails.getName());
        customer1.setAddress(customerDetails.getAddress());
        customer1.setEmail(customerDetails.getEmail());

        final Customer updatedCustomer=customerRepository.save(customer1);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(customerRepository.getReferenceById(id)==null)) {
            customerRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
