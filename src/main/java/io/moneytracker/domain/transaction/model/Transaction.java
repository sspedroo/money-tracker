package io.moneytracker.domain.transaction.model;

import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.paymentMethods.model.PaymentMethod;
import io.moneytracker.domain.subcategory.model.Subcategory;
import io.moneytracker.domain.transaction.enums.TypeTransaction;
import io.moneytracker.domain.user.model.User;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "tb_transaction")
@Table(name = "tb_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeTransaction typeTransaction;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private BigDecimal transactionValue;
    private String description;
    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
