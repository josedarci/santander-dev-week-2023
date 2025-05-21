package me.dio.service;

import me.dio.domain.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void deposit(Long accountId, BigDecimal amount);
    void withdraw(Long accountId, BigDecimal amount);
    void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount);
    List<Transaction> getTransactionsByAccountId(Long accountId);
}
