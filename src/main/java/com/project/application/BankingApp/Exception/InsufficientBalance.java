package com.project.application.BankingApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class InsufficientBalance extends RuntimeException {

    private double accountBalance;

    public InsufficientBalance(double accountBalance){
        super(String.format("Insufficient Balance = '%s' ",accountBalance));
    }


}


