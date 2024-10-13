package com.jrtp.service;

import com.jrtp.dto.OrderItemDTO;
import com.jrtp.dto.ReportDTO;
import com.jrtp.entities.Order;
import com.jrtp.entities.OrderItem;
import com.jrtp.repos.OrderItemRepo;
import com.jrtp.repos.OrderRepo;
import com.jrtp.specification.ReportSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    public List<Order> filterOrders(ReportDTO reportDTO) {
        Specification<Order> specification = Specification
                .where(ReportSpecification.hasCustomerEmail(reportDTO.getCustomerEmail()))
                .and(ReportSpecification.hasStartDate(reportDTO.getStartDate()))
                .and(ReportSpecification.hasEndDate(reportDTO.getEndDate()));

        return orderRepo.findAll(specification);
    }


    public List<OrderItemDTO> getOrderItems(Integer orderId) {
        List<OrderItemDTO> orderItemList = orderItemRepo.findByOrderOrderId(orderId);
        System.out.println(orderItemList);
        return orderItemList;
    }
}
