package com.project.application.BankingApp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="Accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "accountHolder_name")
    @NotEmpty
    private String accountHolderName;

    @Column(name="account_balance")
    @NotEmpty
    private double accountBalance;

    @Column(name="accountCreatedAt")
    @CreationTimestamp
    private LocalDate accountCreationDate;




}
