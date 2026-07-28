package com.project.application.BankingApp.Service.ServiceImplementation;

import com.project.application.BankingApp.Entity.Account;
import com.project.application.BankingApp.Exception.AccountNotFound;
import com.project.application.BankingApp.Exception.InsufficientBalance;
import com.project.application.BankingApp.Repository.AccountRepository;
import com.project.application.BankingApp.Service.AccountService;
import com.project.application.BankingApp.dto.AccountDto;
import com.project.application.BankingApp.dto.TransferFundDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
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
        if(!accountRepository.findById(id).isPresent()){
            throw new AccountNotFound(id);
        }
        return this.modelMapper.map(this.accountRepository.findById(id), AccountDto.class);
    }

    @Override
    public String DeleteAccount(Long id) {
        if(!accountRepository.findById(id).isPresent()){
            throw new AccountNotFound(id);
        }
        else{
            accountRepository.deleteById(id);
        }
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

    @Override
    public AccountDto DepositAmount(double DepositAmount, Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        double BalanceAfterDeposit = DepositAmount + account.getAccountBalance();
        account.setAccountBalance(BalanceAfterDeposit);
        accountRepository.save(account);
        return this.modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto WithdrawAmount(double WithdrawAmount, Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        if(account.getAccountBalance() <= 100 || WithdrawAmount>=account.getAccountBalance()){
            throw new InsufficientBalance(account.getAccountBalance());
        } else{
            double AmountLeft = account.getAccountBalance() - WithdrawAmount;
            account.setAccountBalance(AmountLeft);
            accountRepository.save(account);
        }
        return this.modelMapper.map(account, AccountDto.class);
    }

    @Override
    public void TransferFundFeature(TransferFundDto transferFundDto) {

        //Sender
        Account sender = accountRepository.findById(transferFundDto.fromAccountId()).orElseThrow(() -> new AccountNotFound(transferFundDto.fromAccountId()));

        //Receiver
        Account receiver = accountRepository.findById(transferFundDto.fromAccountId()).orElseThrow(() -> new AccountNotFound(transferFundDto.fromAccountId()));

        sender.setAccountBalance(sender.getAccountBalance() - transferFundDto.amount());
        accountRepository.save(sender);

        receiver.setAccountBalance(receiver.getAccountBalance() + transferFundDto.amount());
        accountRepository.save(receiver);


    }


}
