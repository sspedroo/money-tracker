package io.moneytracker.domain.paymentMethods.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PixPayment extends PaymentMethod{
    private String bank;
}
