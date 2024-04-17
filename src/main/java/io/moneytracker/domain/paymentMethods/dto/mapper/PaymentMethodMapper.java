package io.moneytracker.domain.paymentMethods.dto.mapper;

import io.moneytracker.domain.paymentMethods.dto.CreditCardResponseDTO;
import io.moneytracker.domain.paymentMethods.model.CreditCardPayment;

public final class PaymentMethodMapper {
    public static CreditCardResponseDTO toCreditCardResponseDTO(CreditCardPayment entity){
        return CreditCardResponseDTO.builder()
                .id(entity.getId())
                .bank(entity.getBank())
                .nickname(entity.getNickname() == null ? null : entity.getNickname())
                .build();
    }
}
