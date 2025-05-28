package com.techlead.dto.request.query3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query34 {
    private String customerName;
    private Long filmCount;
    private BigDecimal totalRentalFee;
}