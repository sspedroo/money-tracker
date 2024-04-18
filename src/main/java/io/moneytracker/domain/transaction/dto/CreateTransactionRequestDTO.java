package io.moneytracker.domain.transaction.dto;

import io.moneytracker.domain.transaction.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequestDTO {
    private BigDecimal value;
    private LocalDate date;
    private String description;
    private TypeTransaction typeTransaction;
    private Long categoryId;
    private Long subcategoryId;
    private Long paymentMethodId;
    private Long userId;
}
