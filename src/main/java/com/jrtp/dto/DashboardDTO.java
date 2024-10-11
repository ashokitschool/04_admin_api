package com.jrtp.dto;

import lombok.Data;

@Data
public class DashboardDTO {
    private Long customersCount;
    private Long ordersCount;
    private Double amountCollected;
    private Long productCount;
}
