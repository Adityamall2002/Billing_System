package com.billing.billingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.billingsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}