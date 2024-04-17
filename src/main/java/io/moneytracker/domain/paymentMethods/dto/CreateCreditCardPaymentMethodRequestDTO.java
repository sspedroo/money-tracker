package io.moneytracker.domain.paymentMethods.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardPaymentMethodRequestDTO {
    @NotBlank(message = "Bank cannot be blank.")
    @Size(min = 2, max = 30, message = "Bank's name need at least 2 letters and 30 at the most")
    private String bank;
    private String nickname;
}
