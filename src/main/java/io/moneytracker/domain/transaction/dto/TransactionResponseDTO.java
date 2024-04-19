package io.moneytracker.domain.transaction.dto;

import io.moneytracker.domain.paymentMethods.model.PaymentMethod;
import io.moneytracker.domain.transaction.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponseDTO {
    private Long id;
    private LocalDate date;
    private TypeTransaction typeTransaction;
    private BigDecimal value;
    private String description;
    private String paymentMethod;
    private String category;
    private String subcategory;
    private String user;
}
