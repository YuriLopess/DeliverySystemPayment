package io.github.yurilopess.paymentMicroservices.controller;

import io.github.yurilopess.paymentMicroservices.dto.PaymentDto;
import io.github.yurilopess.paymentMicroservices.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public Page<PaymentDto> listAll(@PageableDefault(size = 10) Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> listById(@PathVariable @NotNull UUID id) {
        PaymentDto dto = service.getById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> save(@RequestBody @Valid PaymentDto dto, UriComponentsBuilder uriComponentsBuilder) {
        PaymentDto payment = service.postPayment(dto);
        URI address = uriComponentsBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();

        return ResponseEntity.created(address).body(payment);
    }

    @PutMapping
    public ResponseEntity<PaymentDto> update(@PathVariable @NotNull UUID id, @RequestBody @Valid PaymentDto dto) {
        PaymentDto updated = service.putPayment(id, dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<PaymentDto> remove(@PathVariable @NotNull UUID id) {
        service.deletePayment(id);

        return ResponseEntity.noContent().build();
    }
}