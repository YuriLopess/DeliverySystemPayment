package io.github.yurilopess.paymentMicroservices.repository;

import io.github.yurilopess.paymentMicroservices.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
