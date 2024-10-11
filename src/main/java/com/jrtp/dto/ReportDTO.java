package com.jrtp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportDTO {
    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;
}
