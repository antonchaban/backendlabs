package ua.kpi.fict.backendlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.fict.backendlabs.entity.AccountEntity;
import ua.kpi.fict.backendlabs.entity.RecordEntity;
import ua.kpi.fict.backendlabs.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("accounts")
    public ResponseEntity createAccount(@RequestBody AccountEntity accountEntity) {
        return ResponseEntity.ok(accountService.createAccount(accountEntity));
    }
}
