package com.flipfit.business;

import com.flipfit.dao.FlipFitPaymentDAOImpl;
import com.flipfit.dao.FlipFitPaymentDAO;
import com.flipfit.bean.Payment;

import java.util.List;

public class PaymentService {

    private FlipFitPaymentDAO FlipFitPaymentDAO = new FlipFitPaymentDAOImpl();

    public void addPayment(Payment payment) {
        FlipFitPaymentDAO.addPayment(payment);
        System.out.println("Payment added successfully.");
    }

    public Payment getPaymentByTransactionId(String transactionId) {
        Payment payment = FlipFitPaymentDAO.getPaymentByTransactionId(transactionId);
        if (payment != null) {
            System.out.println("Fetched payment details successfully!");
        } else {
            System.out.println("Payment not found for transaction ID: " + transactionId);
        }
        return payment;
    }

    public boolean updatePaymentStatus(String transactionId, String newStatus) {
        boolean success = FlipFitPaymentDAO.updatePaymentStatus(transactionId, newStatus);
        if (success) {
            System.out.println("Payment status updated successfully!");
        } else {
            System.out.println("Failed to update payment status.");
        }
        return success;
    }

    public void deletePayment(String transactionId) {
        FlipFitPaymentDAO.deletePayment(transactionId);
        System.out.println("Payment deleted successfully.");
    }

    public List<Payment> getAllPayments() {
        List<Payment> allPayments = FlipFitPaymentDAO.getAllPayments();
        System.out.println("Fetched all payments successfully!");
        return allPayments;
    }
}

