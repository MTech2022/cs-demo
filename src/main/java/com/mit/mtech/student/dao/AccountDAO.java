/**
 *
 */
package com.mit.mtech.student.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Philippe
 */
@Repository
public class AccountDAO {

  private final DataSource dataSource;
  private final EntityManager em;

  public AccountDAO(DataSource dataSource, EntityManager em) {
    this.dataSource = dataSource;
    this.em = em;
  }

  public List<AccountDTO> unsafeFindAccountsByCustomerId(String customerId) {

    String sql =
        "select " + "customer_id,acc_number,branch_id,balance,passwd from Accounts where customer_id = " + customerId;

    System.out.println("----------------------------------my sql query----------------------------------------------");
    System.out.println(sql);
    try (Connection c = dataSource.getConnection();
        ResultSet rs = c.createStatement()
            .executeQuery(sql)) {
      List<AccountDTO> accounts = new ArrayList<>();
      while (rs.next()) {
        AccountDTO acc = AccountDTO.builder()
            .customerId(rs.getString("customer_id"))
            .branchId(rs.getString("branch_id"))
            .accNumber(rs.getString("acc_number"))
            .passwd(rs.getString("passwd"))
            .balance(rs.getBigDecimal("balance"))
            .build();

        accounts.add(acc);
      }

      return accounts;
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }


  public List<AccountDTO> findAccountsByCustomerIdSafe(String customerId) {

    String jql = "from Account where customerId = :customerId";
    TypedQuery<Account> q = em.createQuery(jql, Account.class)
        .setParameter("customerId", customerId);

    return q.getResultList()
        .stream()
        .map(a -> AccountDTO.builder()
            .accNumber(a.getAccNumber())
            .balance(a.getBalance())
            .branchId(a.getAccNumber())
            .customerId(a.getCustomerId())
            .build())
        .collect(Collectors.toList());
  }
}
