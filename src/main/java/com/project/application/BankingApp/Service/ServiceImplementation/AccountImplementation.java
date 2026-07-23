package com.project.application.BankingApp.Service.ServiceImplementation;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.Repository.AccountRepository;
import com.project.application.BankingApp.Service.AccountService;
import com.project.application.BankingApp.dto.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountImplementation implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto AddAccount(Account account) {
        account.getAccountHolderName();
        account.getAccountBalance();
        account.getAccountCreationDate();
        return this.modelMapper.map(this.accountRepository.save(account), AccountDto.class);
    }
}
