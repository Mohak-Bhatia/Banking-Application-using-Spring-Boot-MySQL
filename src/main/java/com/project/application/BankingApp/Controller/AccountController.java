package com.project.application.BankingApp.Controller;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.Service.ServiceImplementation.AccountImplementation;
import com.project.application.BankingApp.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api /accounts"})
public class AccountController {

    @Autowired
    AccountImplementation accountImplementation;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDto> CreateAccount(@RequestBody Account account){
        AccountDto accountDto= accountImplementation.AddAccount(account);
        return new ResponseEntity(accountDto, HttpStatus.CREATED);
    }

    @GetMapping({"/id"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AccountDto> GetAccount(@PathVariable Long id){
        AccountDto accountDto= accountImplementation.GetAccount(id);
        return new ResponseEntity(accountDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping({"/id"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> DeleteAccount(@PathVariable Long id){
        String message = accountImplementation.DeleteAccount(id);
        return new ResponseEntity(message, HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AccountDto>> GetAllAccounts(){
        List<AccountDto> accountDto= accountImplementation.GetAllAccounts();
        return new ResponseEntity(accountDto, HttpStatus.ACCEPTED);
    }







}
