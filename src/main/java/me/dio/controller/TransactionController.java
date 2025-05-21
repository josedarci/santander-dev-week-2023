package me.dio.controller;

import me.dio.domain.model.Transaction;
import me.dio.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @Operation(summary = "Realiza um depósito em conta")
    @PostMapping("/deposit")
    public void deposit(
            @Parameter(description = "ID da conta que receberá o depósito") @RequestParam Long accountId,
            @Parameter(description = "Valor a ser depositado") @RequestParam BigDecimal amount
    ) {
        transactionService.deposit(accountId, amount);
    }

    @Operation(summary = "Realiza um saque da conta")
    @PostMapping("/withdraw")
    public void withdraw(
            @Parameter(description = "ID da conta de onde será retirado o valor") @RequestParam Long accountId,
            @Parameter(description = "Valor a ser sacado") @RequestParam BigDecimal amount
    ) {
        transactionService.withdraw(accountId, amount);
    }

    @Operation(summary = "Realiza uma transferência entre contas")
    @PostMapping("/transfer")
    public void transfer(
            @Parameter(description = "ID da conta de origem") @RequestParam Long fromAccountId,
            @Parameter(description = "ID da conta de destino") @RequestParam Long toAccountId,
            @Parameter(description = "Valor a ser transferido") @RequestParam BigDecimal amount
    ) {
        transactionService.transfer(fromAccountId, toAccountId, amount);
    }

    @Operation(summary = "Lista as transações de uma conta")
    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactions(
            @Parameter(description = "ID da conta") @PathVariable Long accountId
    ) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
