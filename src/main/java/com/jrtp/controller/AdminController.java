package com.jrtp.controller;


import com.jrtp.dto.DashboardDTO;
import com.jrtp.dto.ReportDTO;
import com.jrtp.entities.Order;
import com.jrtp.service.DashboardService;
import com.jrtp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    public DashboardService dashboardService;

    @Autowired
    public ReportService reportService;

    @GetMapping(value = "/dashboard")
    public ResponseEntity<DashboardDTO> getDashboardData() {
        DashboardDTO dashboardDTO = dashboardService.fetchDashboardValues();
        return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/filter")
    public List<Order> filterOrders(@RequestBody ReportDTO reportDTO) {
        return reportService.filterOrders(reportDTO);
    }
}
