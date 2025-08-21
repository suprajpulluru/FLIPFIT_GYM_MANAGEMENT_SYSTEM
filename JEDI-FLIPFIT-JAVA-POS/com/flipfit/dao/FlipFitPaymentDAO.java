package com.flipfit.dao;

import com.flipfit.bean.FlipFitPayment;

import java.util.List;

public interface FlipFitPaymentDAO {
    void addPayment(FlipFitPayment payment);
    FlipFitPayment getPaymentByTransactionId(String transactionId);
    boolean updatePaymentStatus(String transactionId, String newStatus);
    void deletePayment(String transactionId);
    List<FlipFitPayment> getAllPayments();
}
