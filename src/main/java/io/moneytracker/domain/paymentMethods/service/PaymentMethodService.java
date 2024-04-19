package io.moneytracker.domain.paymentMethods.service;

import io.moneytracker.domain.paymentMethods.dto.CreateCreditCardPaymentMethodRequestDTO;
import io.moneytracker.domain.paymentMethods.dto.CreatePixPaymentMethodRequestDTO;
import io.moneytracker.domain.paymentMethods.dto.CreditCardResponseDTO;
import io.moneytracker.domain.paymentMethods.dto.PixResponseDTO;
import io.moneytracker.domain.paymentMethods.dto.mapper.PaymentMethodMapper;
import io.moneytracker.domain.paymentMethods.model.CreditCardPayment;
import io.moneytracker.domain.paymentMethods.model.PaymentMethod;
import io.moneytracker.domain.paymentMethods.model.PixPayment;
import io.moneytracker.domain.paymentMethods.repository.PaymentMethodRepository;
import io.moneytracker.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    @Transactional
    public CreditCardResponseDTO addCreditCard(CreateCreditCardPaymentMethodRequestDTO dto){
        log.info("adding a new credit card as payment method");
        CreditCardPayment creditCardPayment = CreditCardPayment.builder()
                .bank(dto.getBank())
                .nickname(dto.getNickname())
                .name("Cartão de Crédito - " + dto.getBank())
                .user(userRepository.findById(dto.getUserId())
                        .orElseThrow(() -> new EntityNotFoundException("User not found.")))
                .build();
        paymentMethodRepository.save(creditCardPayment);
        log.info("credit card added successfully");
        return PaymentMethodMapper.toCreditCardResponseDTO(creditCardPayment);
    }

    @Transactional
    public PixResponseDTO addPix(CreatePixPaymentMethodRequestDTO dto){
        log.info("adding a new pix as payment method");
        PixPayment pix = PixPayment.builder()
                .bank(dto.getBank())
                .user(userRepository.findById(dto.getUserId())
                        .orElseThrow(() -> new EntityNotFoundException("User not found.")))
                .name("Pix - " + dto.getBank())
                .build();
        paymentMethodRepository.save(pix);
        log.info("pix added successfully");
        return PaymentMethodMapper.toPixResponseDTO(pix);
    }

//    public void removeCreditCardAsPaymentMethod(Long creditCardId){
//        PaymentMethod paymentMethod = paymentMethodRepository.findById(creditCardId)
//                .orElseThrow((() -> new EntityNotFoundException("Credit card not found.")));
//        Set<PaymentMethod> userPaymentMethod = paymentMethod.getUser().getPaymentMethods();
//        userPaymentMethod.remove(paymentMethod);
//        paymentMethodRepository.save(paymentMethod);
//    }


}
