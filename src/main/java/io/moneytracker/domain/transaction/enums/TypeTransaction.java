package io.moneytracker.domain.transaction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeTransaction {
    INCOME(1, "Income"),
    EXPENSE(2, "Expense");

    private final Integer id;
    private final String type;
}
