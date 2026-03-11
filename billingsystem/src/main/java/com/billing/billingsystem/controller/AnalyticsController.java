package com.billing.billingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.billingsystem.service.AnalyticsService;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {

        return analyticsService.getDashboardData();
    }
}