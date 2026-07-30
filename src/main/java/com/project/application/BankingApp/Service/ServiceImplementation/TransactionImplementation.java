package com.project.application.BankingApp.Service.ServiceImplementation;

import com.project.application.BankingApp.Entity.Transaction;
import com.project.application.BankingApp.Repository.TransactionRepository;
import com.project.application.BankingApp.Service.TransactionService;
import org.modelmapper.ModelMapper;
import com.project.application.BankingApp.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionImplementation implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TransactionDto> GetAllTransactionsByID(Long id) {
        List<Transaction> transactions = transactionRepository.findByAccountIdOrderByTimestampDesc(id);
        List<TransactionDto> transactionDtos = new ArrayList<>();

        for (Transaction t:transactions){
            transactionDtos.add(modelMapper.map(t, TransactionDto.class));
        }

        return transactionDtos;
    }
}
