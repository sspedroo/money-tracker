package io.moneytracker.domain.transaction.dto.mapper;

import io.moneytracker.domain.transaction.dto.TransactionResponseDTO;
import io.moneytracker.domain.transaction.model.Transaction;

public final class TransactionMapper {

    public static TransactionResponseDTO toTransactionResponseDTO(Transaction entity){
        return TransactionResponseDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .typeTransaction(entity.getTypeTransaction())
                .value(entity.getTransactionValue())
                .description(entity.getDescription() == null ? null : entity.getDescription())
                .paymentMethod(entity.getPaymentMethod().getName() == null ? null : entity.getPaymentMethod().getName())
                .category(entity.getCategory().getName())
                .subcategory(entity.getSubcategory().getName() == null ? null : entity.getSubcategory().getName())
                .user(entity.getUser().getName())
                .build();
    }
}
