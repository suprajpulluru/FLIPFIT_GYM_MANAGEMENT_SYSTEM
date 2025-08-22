package com.flipfit.business;

import com.flipfit.bean.FlipFitPayment;
import com.flipfit.dao.FlipFitPaymentDAO;
import com.flipfit.dao.FlipFitPaymentDAOImpl;

import java.util.List;


/*
 *@Author : "Akanksha"
 *@ClassName: "PaymentService"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.PaymentService"
 */
public class PaymentService implements PaymentServiceInterface {

    // Instantiating the DAO to interact with the data layer
    private final FlipFitPaymentDAO paymentDAO = new FlipFitPaymentDAOImpl();

    @Override
    public void addPayment(FlipFitPayment payment) {
        paymentDAO.addPayment(payment);
        System.out.println("Payment with Transaction ID " + payment.getTransactionId() + " was added successfully.");
    }

    @Override
    public FlipFitPayment getPaymentByTransactionId(String transactionId) {
        FlipFitPayment payment = paymentDAO.getPaymentByTransactionId(transactionId);
        if (payment != null) {
            System.out.println("Fetched payment details successfully!");
        } else {
            System.out.println("Payment not found for transaction ID: " + transactionId);
        }
        return payment;
    }

    @Override
    public boolean updatePaymentStatus(String transactionId, String newStatus) {
        boolean isUpdated = paymentDAO.updatePaymentStatus(transactionId, newStatus);
        if (isUpdated) {
            System.out.println("Payment status updated successfully!");
        } else {
            System.out.println("Failed to update payment status for transaction ID: " + transactionId);
        }
        return isUpdated;
    }

    @Override
    public void deletePayment(String transactionId) {
        paymentDAO.deletePayment(transactionId);
        System.out.println("Payment with transaction ID " + transactionId + " deleted successfully.");
    }

    @Override
    public List<FlipFitPayment> getAllPayments() {
        List<FlipFitPayment> allPayments = paymentDAO.getAllPayments();
        System.out.println("Fetched all " + allPayments.size() + " payments successfully!");
        return allPayments;
    }
}