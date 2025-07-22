package com.hotel_management.service;

import com.hotel_management.model.Invoice;
import com.hotel_management.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Long invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        return invoice.orElse(null);
    }
    public Invoice updateInvoice(Long invoiceId, Invoice invoiceDetails) {
        Invoice invoice = getInvoiceById(invoiceId);
        if (invoice != null) {
            invoice.setAmount(invoiceDetails.getAmount());
            invoice.setDate(invoiceDetails.getDate());
            invoice.setPaymentStatus(invoiceDetails.getPaymentStatus());
            invoice.setReservation(invoiceDetails.getReservation());
            return invoiceRepository.save(invoice);
        }
        return null;
    }

    public void deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }

    public List<Invoice> listInvoices() {
        return invoiceRepository.findAll();
    }
}
