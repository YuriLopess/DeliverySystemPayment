package io.github.yurilopess.paymentMicroservices.service;

import io.github.yurilopess.paymentMicroservices.dto.PaymentDto;
import io.github.yurilopess.paymentMicroservices.model.Payment;
import io.github.yurilopess.paymentMicroservices.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import io.github.yurilopess.paymentMicroservices.model.Status;


import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PaymentDto> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(p -> modelMapper.map(p, PaymentDto.class));
    }

    public PaymentDto getById(UUID id) {
        Payment payment = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(payment, PaymentDto.class);
    }

    public PaymentDto putPayment(UUID id, PaymentDto dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setId(id);
        payment = repository.save(payment);

        return modelMapper.map(payment, PaymentDto.class);
    }

    public void deletePayment(UUID id) {
        repository.deleteById(id);
    }

    public PaymentDto postPayment(PaymentDto dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);

        return modelMapper.map(payment, PaymentDto.class);
    }
}
