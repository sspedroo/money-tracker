package io.moneytracker.domain.transaction.service;

import io.moneytracker.domain.category.repository.CategoryRepository;
import io.moneytracker.domain.paymentMethods.repository.PaymentMethodRepository;
import io.moneytracker.domain.subcategory.repository.SubcategoryRepository;
import io.moneytracker.domain.transaction.dto.CreateTransactionRequestDTO;
import io.moneytracker.domain.transaction.dto.TransactionResponseDTO;
import io.moneytracker.domain.transaction.dto.mapper.TransactionMapper;
import io.moneytracker.domain.transaction.model.Transaction;
import io.moneytracker.domain.transaction.repository.TransactionRepository;
import io.moneytracker.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    @Transactional
    public TransactionResponseDTO addTransaction(CreateTransactionRequestDTO dto){
        log.info("adding a new transaction");
        Transaction transaction = Transaction.builder()
                .date(dto.getDate())
                .typeTransaction(dto.getTypeTransaction())
                .transactionValue(dto.getValue())
                .description(dto.getDescription())
                .paymentMethod(paymentMethodRepository.findById(dto.getPaymentMethodId())
                        .orElseThrow(() -> new EntityNotFoundException("Payment Method not found.")))
                .category(categoryRepository.findById(dto.getCategoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found.")))
//                .subcategory(subcategoryRepository.findById(dto.getSubcategoryId())
//                        .orElseThrow(() -> new EntityNotFoundException("Subcategory not found.")))
                .subcategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not " +
                        "found"))
                        .getSubcategories().stream()
                        .filter(sb -> sb.getId().equals(dto.getSubcategoryId()))
                        .findFirst()
                        .orElseThrow(() -> new EntityNotFoundException("Subcategory not found.")))
                .user(userRepository.findById(dto.getUserId())
                        .orElseThrow(() -> new EntityNotFoundException("User not found.")))
                .build();

        transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponseDTO(transaction);
    }
}
