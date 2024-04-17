package io.moneytracker.domain.paymentMethods.repository;

import io.moneytracker.domain.paymentMethods.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
