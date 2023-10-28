/*
Name: Tushar Subhash Shinde
Email: tusharsshinde15@gmail.com

 */
package com.example.Sunbase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired CustomerRepository customerRepository;
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);


    }
/////////////////////////////////////////////

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
/////////////////////////////////////////////
    public boolean deleteCustomerByUuid(UUID uuid) {
        Optional<Customer> optionalCustomer = customerRepository.findById(uuid);
        if (optionalCustomer.isPresent()) {
            customerRepository.delete(optionalCustomer.get());
            return true;
        }
        return false;
    }

//////////////////////////////////////////////
    public boolean updateCustomerByUuid(UUID uuid, Customer customerData) {
        Optional<Customer> optionalCustomer = customerRepository.findById(uuid);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            // Update customer data
            customer.setFirstName(customerData.getFirstName());
            customer.setLastName(customerData.getLastName());
            customer.setStreet(customerData.getStreet());
            customer.setAddress(customerData.getAddress());
            customer.setCity(customerData.getCity());
            customer.setState(customerData.getState());
            customer.setEmail(customerData.getEmail());
            customer.setPhone(customerData.getPhone());

            customerRepository.save(customer); // Save the updated customer
            return true;
        }
        return false;
    }

}
