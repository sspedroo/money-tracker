package io.moneytracker.domain.transaction.service;

import io.moneytracker.domain.category.repository.CategoryRepository;
import io.moneytracker.domain.paymentMethods.repository.PaymentMethodRepository;
import io.moneytracker.domain.transaction.dto.CreateTransactionRequestDTO;
import io.moneytracker.domain.transaction.model.Transaction;
import io.moneytracker.domain.transaction.repository.TransactionRepository;
import io.moneytracker.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    public void addTransaction(CreateTransactionRequestDTO dto){

    }
}
