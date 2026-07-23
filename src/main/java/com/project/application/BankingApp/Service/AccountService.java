package com.project.application.BankingApp.Service;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.dto.AccountDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    AccountDto AddAccount(Account account);


}
