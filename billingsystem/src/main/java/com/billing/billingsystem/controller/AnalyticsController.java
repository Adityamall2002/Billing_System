package com.billing.billingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.billingsystem.repository.BillRepository;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/total-sales")
    public Double totalSales() {

        return billRepository.getTotalSales();
    }
}