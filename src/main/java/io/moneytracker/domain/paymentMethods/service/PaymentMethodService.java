package io.moneytracker.domain.paymentMethods.service;

import io.moneytracker.domain.paymentMethods.dto.CreateCreditCardPaymentMethodRequestDTO;
import io.moneytracker.domain.paymentMethods.dto.CreatePixPaymentMethodRequestDTO;
import io.moneytracker.domain.paymentMethods.dto.CreditCardResponseDTO;
import io.moneytracker.domain.paymentMethods.dto.PixResponseDTO;
import io.moneytracker.domain.paymentMethods.dto.mapper.PaymentMethodMapper;
import io.moneytracker.domain.paymentMethods.model.CreditCardPayment;
import io.moneytracker.domain.paymentMethods.model.PixPayment;
import io.moneytracker.domain.paymentMethods.repository.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodRepository repository;

    @Transactional
    public CreditCardResponseDTO addCreditCard(CreateCreditCardPaymentMethodRequestDTO dto){
        CreditCardPayment creditCardPayment = CreditCardPayment.builder()
                .bank(dto.getBank())
                .nickname(dto.getNickname())
                .build();
        repository.save(creditCardPayment);
        return PaymentMethodMapper.toCreditCardResponseDTO(creditCardPayment);
    }

    @Transactional
    public PixResponseDTO addPix(CreatePixPaymentMethodRequestDTO dto){
        PixPayment pix = PixPayment.builder()
                .bank(dto.getBank())
                .build();
        repository.save(pix);
        return PaymentMethodMapper.toPixResponseDTO(pix);
    }
}
