package com.project.application.BankingApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFound extends RuntimeException{

    private Long id;
    public AccountNotFound (Long id){
        super(String.format("Account with id = '%s' not found",id));
        this.id=id;
    }



}
