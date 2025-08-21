package com.flipfit.dao;

import com.flipfit.bean.FlipFitPayment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *@Author : "Dhara Periwal"
 *@ClassName: "FlipFitPaymentDAOImpl"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.FlipFitGym, com.flipfit.bean.FlipFitGymOwner, java.util.List"
 */
public class FlipFitPaymentDAOImpl implements FlipFitPaymentDAO {

    // Using a HashMap to simulate a database table for payments
    private static final Map<String, FlipFitPayment> paymentTable = new HashMap<>();

    @Override
    public void addPayment(FlipFitPayment payment) {
        if (payment != null && payment.getTransactionId() != null) {
            paymentTable.put(payment.getTransactionId(), payment);
        }
    }

    @Override
    public FlipFitPayment getPaymentByTransactionId(String transactionId) {
        return paymentTable.get(transactionId);
    }

    @Override
    public boolean updatePaymentStatus(String transactionId, String newStatus) {
        FlipFitPayment payment = paymentTable.get(transactionId);
        if (payment != null) {
            payment.setPaymentStatus(newStatus);
            return true;
        }
        return false;
    }

    @Override
    public void deletePayment(String transactionId) {
        paymentTable.remove(transactionId);
    }

    @Override
    public List<FlipFitPayment> getAllPayments() {
        return new ArrayList<>(paymentTable.values());
    }
}