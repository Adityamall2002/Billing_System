package com.billing.billingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.billing.billingsystem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT SUM(b.totalAmount) FROM Bill b")
    Double getTotalSales();
}