package com.mit.mtech.student.dao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountDTO {
    
    private String customerId;
    private String accNumber;
    private String branchId;
    private BigDecimal balance;
}
