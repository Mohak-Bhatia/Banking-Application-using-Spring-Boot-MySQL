package com.project.application.BankingApp.Service.ServiceImplementation;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.Repository.AccountRepository;
import com.project.application.BankingApp.Service.AccountService;
import com.project.application.BankingApp.dto.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public AccountDto GetAccount(Long id) {
        return this.modelMapper.map(this.accountRepository.findById(id), AccountDto.class);
    }

    @Override
    public String DeleteAccount(Long id) {
        accountRepository.deleteById(id);
        return "Account with id" + id + "is deleted";
    }

    @Override
    public List<AccountDto> GetAllAccounts() {
        List<Account> AccountList = accountRepository.findAll();
        List<AccountDto> AccountDtoList = new ArrayList<>();
        for(Account a: AccountList){
            AccountDtoList.add(modelMapper.map(a, AccountDto.class));
        }
        return AccountDtoList;
    }


}
