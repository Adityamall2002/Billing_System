package com.billing.billingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.billingsystem.repository.BillRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AnalyticsService {

    @Autowired
    private BillRepository billRepository;

    public Map<String, Object> getDashboardData() {

        Map<String, Object> dashboard = new HashMap<>();

        Double totalRevenue = billRepository.getTotalRevenue();
        Long totalBills = billRepository.getTotalBills();
        Double todayRevenue = billRepository.getTodayRevenue(LocalDate.now());
        Long todayBills = billRepository.getTodayBills(LocalDate.now());

        dashboard.put("totalRevenue", totalRevenue != null ? totalRevenue : 0);
        dashboard.put("totalBills", totalBills != null ? totalBills : 0);
        dashboard.put("todayRevenue", todayRevenue != null ? todayRevenue : 0);
        dashboard.put("todayBills", todayBills != null ? todayBills : 0);

        return dashboard;
    }
}