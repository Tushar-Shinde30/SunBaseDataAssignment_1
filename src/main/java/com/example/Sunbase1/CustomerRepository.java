/*
Name: Tushar Subhash Shinde
Email: tusharsshinde15@gmail.com

 */

package com.example.Sunbase1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer,UUID> {


}
