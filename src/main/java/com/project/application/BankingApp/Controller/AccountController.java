package com.project.application.BankingApp.Controller;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.Service.ServiceImplementation.AccountImplementation;
import com.project.application.BankingApp.dto.AccountDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api /accounts"})
public class AccountController {

    @Autowired
    AccountImplementation accountImplementation;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDto> CreateAccount(@Valid @RequestBody Account account){
        AccountDto accountDto= accountImplementation.AddAccount(account);
        return new ResponseEntity(accountDto, HttpStatus.CREATED);
    }

    @GetMapping({"/id={id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AccountDto> GetAccount(@PathVariable("id") Long id){
        AccountDto accountDto= accountImplementation.GetAccount(id);
        return new ResponseEntity(accountDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping({"/id={id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> DeleteAccount(@PathVariable("id") Long id){
        String message = accountImplementation.DeleteAccount(id);
        return new ResponseEntity(message, HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AccountDto>> GetAllAccounts(){
        List<AccountDto> accountDto= accountImplementation.GetAllAccounts();
        return new ResponseEntity(accountDto, HttpStatus.ACCEPTED);
    }

    @PutMapping({"/deposit/id={id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AccountDto> DepositAmount(@RequestBody Map<String, Double> request, @PathVariable("id") Long id){
        Double DepositAmount = request.get("DepositAmount");
        AccountDto accountDto = accountImplementation.DepositAmount(DepositAmount, id);
        return new ResponseEntity<>(accountDto, HttpStatus.ACCEPTED);
    }

    @PutMapping({"/withdraw/id={id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AccountDto> WithdrawAmount(@RequestBody  Map<String, Double> request, @PathVariable("id") Long id){
        Double WithdrawAmount = request.get("WithdrawAmount");
        AccountDto accountDto = accountImplementation.WithdrawAmount(WithdrawAmount,id);
        return new ResponseEntity<>(accountDto, HttpStatus.ACCEPTED);
    }



}
