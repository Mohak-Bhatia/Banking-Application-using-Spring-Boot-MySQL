package com.project.application.BankingApp.Controller;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.Service.ServiceImplementation.AccountImplementation;
import com.project.application.BankingApp.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/accounts"})
public class AccountController {

    @Autowired
    AccountImplementation accountImplementation;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDto> CreateAccount(@RequestBody Account account){
        AccountDto accountDto= this.accountImplementation.AddAccount(account);
        return new ResponseEntity(accountDto, HttpStatus.CREATED);
    }



}
