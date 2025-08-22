package com.flipfit.dao;

import com.flipfit.bean.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
/*
 *@Author : "Dhara Periwal"
 *@ClassName: "FlipFitPaymentDAOImpl"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.FlipFitGym, com.flipfit.bean.FlipFitGymOwner, java.util.List"
 */

public class FlipFitPaymentDAOImpl implements FlipFitPaymentDAO {

    private static Map<String, Payment> paymentMap = new ConcurrentHashMap<>();

    @Override
    public void addPayment(Payment payment) {
        paymentMap.put(payment.getTransactionId(), payment);
        System.out.println("Payment with transaction ID " + payment.getTransactionId() + " added successfully.");
    }

    @Override
    public Payment getPaymentByTransactionId(String transactionId) {
        return paymentMap.get(transactionId);
    }

    @Override
    public boolean updatePaymentStatus(String transactionId, String newStatus) {
        Payment payment = paymentMap.get(transactionId);
        if (payment != null) {
            payment.setPaymentStatus(newStatus);
            System.out.println("Payment status for " + transactionId + " updated to " + newStatus);
            return true;
        } else {
            System.out.println("Payment with transaction ID " + transactionId + " not found.");
            return false;
        }
    }

    @Override
    public void deletePayment(String transactionId) {
        if (paymentMap.remove(transactionId) != null) {
            System.out.println("Payment with transaction ID " + transactionId + " deleted successfully.");
        } else {
            System.out.println("Payment with transaction ID " + transactionId + " not found.");
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(paymentMap.values());
    }
}
