package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entities.Customer;

//to perform CRUD operations
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
