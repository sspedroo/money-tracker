package io.moneytracker.domain.paymentMethods.dto.mapper;

import io.moneytracker.domain.paymentMethods.dto.CreditCardResponseDTO;
import io.moneytracker.domain.paymentMethods.dto.PixResponseDTO;
import io.moneytracker.domain.paymentMethods.model.CreditCardPayment;
import io.moneytracker.domain.paymentMethods.model.PixPayment;

public final class PaymentMethodMapper {
    public static CreditCardResponseDTO toCreditCardResponseDTO(CreditCardPayment entity){
        return CreditCardResponseDTO.builder()
                .id(entity.getId())
                .bank(entity.getBank())
                .nickname(entity.getNickname() == null ? null : entity.getNickname())
                .build();
    }

    public static PixResponseDTO toPixResponseDTO(PixPayment entity){
        return PixResponseDTO.builder()
                .id(entity.getId())
                .bank(entity.getBank())
                .build();
    }
}
