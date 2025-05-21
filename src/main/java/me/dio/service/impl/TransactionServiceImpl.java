package me.dio.service.impl;

import me.dio.domain.model.*;
import me.dio.domain.repository.AccountRepository;
import me.dio.domain.repository.TransactionRepository;
import me.dio.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);

        recordTransaction(TransactionType.DEPOSIT, amount, null, account);
    }

    @Override
    public void withdraw(Long accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);

        recordTransaction(TransactionType.WITHDRAW, amount, account, null);
    }

    @Override
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Account origin = getAccount(fromAccountId);
        Account destination = getAccount(toAccountId);

        if (origin.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Saldo insuficiente para transferência");
        }

        origin.setBalance(origin.getBalance().subtract(amount));
        destination.setBalance(destination.getBalance().add(amount));

        accountRepository.save(origin);
        accountRepository.save(destination);

        recordTransaction(TransactionType.TRANSFER, amount, origin, destination);
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByOriginAccountIdOrDestinationAccountId(accountId, accountId);
    }

    private void recordTransaction(TransactionType type, BigDecimal amount, Account origin, Account destination) {
        Transaction tx = new Transaction();
        tx.setType(type);
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        tx.setOriginAccount(origin);
        tx.setDestinationAccount(destination);
        transactionRepository.save(tx);
    }

    private Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
}
