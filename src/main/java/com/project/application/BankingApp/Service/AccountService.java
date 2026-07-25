package com.project.application.BankingApp.Service;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AccountDto AddAccount(Account account);

    AccountDto GetAccount(Long id);

    String DeleteAccount(Long id);

    List<AccountDto> GetAllAccounts();

    AccountDto DepositAmount(double DepositAmount, Long id);

    AccountDto WithdrawAmount(double WithdrawAmount, Long id);


}
