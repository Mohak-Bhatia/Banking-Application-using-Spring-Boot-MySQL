package com.project.application.BankingApp.Service;

import com.project.application.BankingApp.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    List<TransactionDto> GetAllTransactionsByID(Long id);
}
