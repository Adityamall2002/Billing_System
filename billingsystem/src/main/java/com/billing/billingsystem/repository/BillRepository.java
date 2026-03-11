package com.billing.billingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.billing.billingsystem.entity.Bill;

import java.time.LocalDate;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT SUM(b.totalAmount) FROM Bill b")
    Double getTotalRevenue();

    @Query("SELECT COUNT(b) FROM Bill b")
    Long getTotalBills();

    @Query("SELECT SUM(b.totalAmount) FROM Bill b WHERE DATE(b.billDate) = :today")
    Double getTodayRevenue(@Param("today") LocalDate today);

    @Query("SELECT COUNT(b) FROM Bill b WHERE DATE(b.billDate) = :today")
    Long getTodayBills(@Param("today") LocalDate today);
}