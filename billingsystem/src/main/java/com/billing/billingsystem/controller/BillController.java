package com.billing.billingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.billingsystem.dto.BillRequest;
import com.billing.billingsystem.entity.Bill;
import com.billing.billingsystem.service.BillService;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/generate")
    public Bill generateBill(@RequestBody BillRequest request) {

        return billService.generateBill(request);
    }
}