package com.mit.mtech.student.api;

import com.mit.mtech.student.dao.AccountDAO;
import com.mit.mtech.student.dao.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SQLInjection {

    @Autowired
    AccountDAO accountDAO;

    @GetMapping(path = "/fetch")
    public ResponseEntity getAllPasswords(@RequestParam(name = "customerId") String customerId) {
        List<AccountDTO> accountDTOS = accountDAO.unsafeFindAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accountDTOS);
    }

    @GetMapping(path = "/fetchsafe")
    public ResponseEntity getRightPasswords(@RequestParam(name = "customerId") String customerId) {
        List<AccountDTO> accountDTOS = accountDAO.findAccountsByCustomerIdSafe(customerId);
        return ResponseEntity.ok(accountDTOS);
    }
}
