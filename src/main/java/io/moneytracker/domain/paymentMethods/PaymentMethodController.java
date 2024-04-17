package io.moneytracker.domain.paymentMethods;

import io.moneytracker.domain.paymentMethods.dto.CreateCreditCardPaymentMethodRequestDTO;
import io.moneytracker.domain.paymentMethods.dto.CreditCardResponseDTO;
import io.moneytracker.domain.paymentMethods.service.PaymentMethodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payment-method")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaymentMethodController {
    private final PaymentMethodService service;


    @PostMapping("/credit-card")
    public ResponseEntity<CreditCardResponseDTO> createCreditCard(@RequestBody @Valid CreateCreditCardPaymentMethodRequestDTO dto){
        CreditCardResponseDTO creditCardResponseDTO = service.addCreditCard(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(creditCardResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(creditCardResponseDTO);
    }
}
