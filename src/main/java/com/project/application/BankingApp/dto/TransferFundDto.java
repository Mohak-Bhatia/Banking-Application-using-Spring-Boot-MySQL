package com.project.application.BankingApp.dto;

public record TransferFundDto(Long fromAccountId, Long toAccountId, double amount) {
}
