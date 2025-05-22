package com.hotel_management.service;

import com.hotel_management.entity.Payment;
import com.hotel_management.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long paymentId){
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.orElse(null);
    }
    public Payment updatePayment(Long paymentId, Payment paymentDetails) {
        Payment payment = getPaymentById(paymentId);
        if (payment != null) {
            payment.setPaymentDate(paymentDetails.getPaymentDate());
            payment.setAmount(paymentDetails.getAmount());
            payment.setPaymentMethod(paymentDetails.getPaymentMethod());
            payment.setInvoice(paymentDetails.getInvoice());
            return paymentRepository.save(payment);
        }
        return null;
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }
}
