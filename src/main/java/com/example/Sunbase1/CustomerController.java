/*
Name: Tushar Subhash Shinde
Email: tusharsshinde15@gmail.com

 */
package com.example.Sunbase1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sunbase/portal/api/assignment.jsp")
public class CustomerController {

    @Autowired CustomerService customerService;

                //1. Create a new Customer:
    @PostMapping("/add")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        if (customer.getFirstName() == null || customer.getLastName() == null) {
            return new ResponseEntity("First Name or Last Name is missing", HttpStatus.BAD_REQUEST);
        }
        Customer response = customerService.createCustomer(customer);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

                //2. Get customer list:
    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customers = customerService.getCustomerList();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
                //3. Delete a customer
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam("cmd") String command, @RequestParam("uuid") UUID uuid) {
        if ("delete".equals(command)) {
            boolean deleted = customerService.deleteCustomerByUuid(uuid);
            if (deleted) {
                return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity("Error Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity("Invalid command", HttpStatus.BAD_REQUEST);
        }
    }
                //4. Update a customer
    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestParam("cmd") String command, @RequestParam("uuid") UUID uuid, @RequestBody Customer customerData) {
        if ("update".equals(command)) {
            boolean updated = customerService.updateCustomerByUuid(uuid, customerData);
            if (updated) {
                return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity("UUID not found", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity("Invalid command", HttpStatus.BAD_REQUEST);
        }
    }

}
