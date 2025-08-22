//package com.flipfit.business;
//
//import com.flipfit.bean.*;
//import java.util.*;
//
//public interface PaymentServiceInterface {
//
//    public Payment getPaymentByTransactionId(String transactionId);
//    public boolean updatePaymentStatus(String transactionId, String newStatus);
//    public void deletePayment(String transactionId);
//    public List<Payment> getAllPayments();
//}

package com.flipfit.business;

import com.flipfit.bean.FlipFitPayment;
import java.util.List;

/*
 *@Author : "Supraj Pulluru"
 *@ClassName: "PaymentServiceInterface"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.PaymentServiceInterface"
 */
public interface PaymentServiceInterface {

    /**
     * Processes the addition of a new payment.
     * @param payment The payment object to be added.
     */
    void addPayment(FlipFitPayment payment);

    /**
     * Retrieves a payment by its unique transaction ID.
     * @param transactionId The ID of the transaction.
     * @return The FlipFitPayment object, or null if not found.
     */
    FlipFitPayment getPaymentByTransactionId(String transactionId);

    /**
     * Updates the status of a specific payment transaction.
     * @param transactionId The ID of the transaction to update.
     * @param newStatus The new status to be set.
     * @return true if the update was successful, false otherwise.
     */
    boolean updatePaymentStatus(String transactionId, String newStatus);

    /**
     * Deletes a payment record.
     * @param transactionId The ID of the transaction to delete.
     */
    void deletePayment(String transactionId);

    /**
     * Retrieves a list of all payments.
     * @return A list containing all payment records.
     */
    List<FlipFitPayment> getAllPayments();
}