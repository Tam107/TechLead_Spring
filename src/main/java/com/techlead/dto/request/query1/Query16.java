package com.techlead.dto.request.query1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query16 {
    private Short storeId;
    private BigDecimal totalRevenue;
}
