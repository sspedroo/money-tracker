package io.moneytracker.domain.paymentMethods.model;

import io.moneytracker.domain.transaction.model.Transaction;
import io.moneytracker.domain.user.model.User;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_payment_method")
@Table(name = "tb_payment_method")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PaymentMethod extends BaseEntity {
    @Column(unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;
    @OneToMany(mappedBy = "paymentMethod")
    private Set<Transaction> transactions = new HashSet<>();
}
