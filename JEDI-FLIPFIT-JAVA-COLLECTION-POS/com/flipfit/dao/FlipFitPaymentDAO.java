package com.flipfit.dao;

import com.flipfit.bean.Payment;
import java.util.List;

public interface FlipFitPaymentDAO {
    void addPayment(Payment payment);
    Payment getPaymentByTransactionId(String transactionId);
    boolean updatePaymentStatus(String transactionId, String newStatus);
    void deletePayment(String transactionId);
    List<Payment> getAllPayments();
}
