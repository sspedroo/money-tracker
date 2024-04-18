package io.moneytracker.domain.paymentMethods.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name = "tb_credit_card")
@Table(name = "tb_credit_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreditCardPayment extends PaymentMethod{
    @Column(nullable = false, length = 30)
    private String bank;
    @Column(unique = true, length = 20)
    private String nickname;
}
