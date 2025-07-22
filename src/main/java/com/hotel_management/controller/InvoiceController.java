package com.hotel_management.controller;

import com.hotel_management.model.Invoice;
import com.hotel_management.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice createdInvoice = invoiceService.createInvoice(invoice);
        return ResponseEntity.ok(createdInvoice);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        return invoice != null ? ResponseEntity.ok(invoice) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long invoiceId, @RequestBody Invoice invoiceDetails) {
        Invoice updatedInvoice = invoiceService.updateInvoice(invoiceId, invoiceDetails);
        return updatedInvoice != null ? ResponseEntity.ok(updatedInvoice) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> listInvoices() {
        List<Invoice> invoices = invoiceService.listInvoices();
        return ResponseEntity.ok(invoices);
    }
}
