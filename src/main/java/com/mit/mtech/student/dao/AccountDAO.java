/**
 * 
 */
package com.mit.mtech.student.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Philippe
 *
 */
@Component
public class AccountDAO {

    private final DataSource dataSource;
    private final EntityManager em;

    public AccountDAO(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    public List<AccountDTO> unsafeFindAccountsByCustomerId(String customerId) {

        String sql = "select " + "customer_id,acc_number,branch_id,balance from Accounts where customer_id = '" + customerId + "'";

        try (Connection c = dataSource.getConnection();
            ResultSet rs = c.createStatement()
                .executeQuery(sql)) {
            List<AccountDTO> accounts = new ArrayList<>();
            while (rs.next()) {
                AccountDTO acc = AccountDTO.builder()
                    .customerId(rs.getString("customer_id"))
                    .branchId(rs.getString("branch_id"))
                    .accNumber(rs.getString("acc_number"))
                    .balance(rs.getBigDecimal("balance"))
                    .build();

                accounts.add(acc);
            }

            return accounts;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
