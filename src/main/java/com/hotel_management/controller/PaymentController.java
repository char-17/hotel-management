package com.hotel_management.controller;

import com.hotel_management.model.Payment;
import com.hotel_management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long paymentId, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentService.updatePayment(paymentId, paymentDetails);
        return updatedPayment != null ? ResponseEntity.ok(updatedPayment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Payment>> listPayments() {
        List<Payment> payments = paymentService.listPayments();
        return ResponseEntity.ok(payments);
    }
}
