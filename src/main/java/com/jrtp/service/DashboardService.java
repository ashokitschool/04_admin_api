package com.jrtp.service;

import com.jrtp.dto.DashboardDTO;
import com.jrtp.entities.Order;
import com.jrtp.entities.Product;
import com.jrtp.repos.CustomerRepo;
import com.jrtp.repos.OrderRepo;
import com.jrtp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;


    public DashboardDTO fetchDashboardValues() {
        DashboardDTO dashboardDTO = new DashboardDTO();

        dashboardDTO.setProductCount(productRepo.count());
        dashboardDTO.setCustomersCount(customerRepo.count());
        dashboardDTO.setAmountCollected(orderRepo.findTotalAmount());
        dashboardDTO.setOrdersCount(orderRepo.count());

        return dashboardDTO;
    }

}
