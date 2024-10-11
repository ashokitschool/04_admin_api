package com.jrtp.service;

import com.jrtp.dto.ReportDTO;
import com.jrtp.entities.Order;
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

    public List<Order> filterOrders(ReportDTO reportDTO) {
        Specification<Order> specification = Specification
                .where(ReportSpecification.hasCustomerEmail(reportDTO.getCustomerEmail()))
                .and(ReportSpecification.hasStartDate(reportDTO.getStartDate()))
                .and(ReportSpecification.hasEndDate(reportDTO.getEndDate()));

        return orderRepo.findAll(specification);
    }
}
