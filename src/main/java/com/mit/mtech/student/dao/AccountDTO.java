package com.mit.mtech.student.dao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@Builder
@ToString
public class AccountDTO {
    
    private String customerId;
    private String accNumber;
    private String branchId;
    private String passwd;
    private BigDecimal balance;
}
