package com.billing.billingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.billingsystem.entity.BillItem;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {
}