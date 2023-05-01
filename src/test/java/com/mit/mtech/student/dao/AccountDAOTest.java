package com.mit.mtech.student.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountDAOTest {

  @Autowired
  private AccountDAO target;

  @Test
  public void givenAVulnerableMethod_whenValidCustomerId_thenReturnSingleAccount() {

    List<AccountDTO> accounts = target.unsafeFindAccountsByCustomerId("'C1'");
    System.out.println(accounts);
    assertThat(accounts).isNotNull();
    assertThat(accounts).isNotEmpty();
    assertThat(accounts).hasSize(1);
  }

  @Test
  public void givenAVulnerableMethod_whenHackedCustomerId_thenReturnAllAccounts() {

    List<AccountDTO> accounts = target.unsafeFindAccountsByCustomerId("'C1' or 1=1");
    System.out.println("``````````````````````````RESULT``````````````````````````");
    System.out.println(accounts);
    System.out.println("======================================================================\n");
    assertThat(accounts).isNotNull();
    assertThat(accounts).isNotEmpty();
    assertThat(accounts).hasSize(3);
  }
}