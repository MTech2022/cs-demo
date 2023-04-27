package com.mit.mtech.student.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountDAOTest {

    @Autowired
    private AccountDAO target;

    @Test
    public void givenAVulnerableMethod_whenValidCustomerId_thenReturnSingleAccount() {

        List<AccountDTO> accounts = target.unsafeFindAccountsByCustomerId("C1");
        assertThat(accounts).isNotNull();
        assertThat(accounts).isNotEmpty();
        assertThat(accounts).hasSize(1);
    }

    @Test
    public void givenAVulnerableMethod_whenHackedCustomerId_thenReturnAllAccounts() {

        List<AccountDTO> accounts = target.unsafeFindAccountsByCustomerId("C1' or '1'='1");
        assertThat(accounts).isNotNull();
        assertThat(accounts).isNotEmpty();
        assertThat(accounts).hasSize(3);
    }
}