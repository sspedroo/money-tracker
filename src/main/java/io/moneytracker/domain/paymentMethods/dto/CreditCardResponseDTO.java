package io.moneytracker.domain.paymentMethods.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardResponseDTO {
    private Long id;
    private String bank;
    private String nickname;
}
