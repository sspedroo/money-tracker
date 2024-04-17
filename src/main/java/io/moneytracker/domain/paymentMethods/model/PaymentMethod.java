package io.moneytracker.domain.paymentMethods.model;

import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_payment_method")
@Table(name = "tb_payment_method")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class PaymentMethod extends BaseEntity {
    @Column(unique = true)
    private String name;
}
