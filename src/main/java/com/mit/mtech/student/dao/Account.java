/**
 * 
 */
package com.mit.mtech.student.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Philippe
 *
 */
@Entity
@Table(name="Accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String customerId;
    private String accNumber;
    private String branchId;
    private BigDecimal balance;

}
