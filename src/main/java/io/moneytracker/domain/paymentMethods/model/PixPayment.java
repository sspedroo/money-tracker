package io.moneytracker.domain.paymentMethods.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name = "tb_pix")
@Table(name = "tb_pix")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PixPayment extends PaymentMethod{
    @Column(nullable = false, length = 30)
    private String bank;
}
