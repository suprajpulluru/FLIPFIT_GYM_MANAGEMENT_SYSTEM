package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface PaymentServiceInterface {

    public Payment getPaymentByTransactionId(String transactionId);
    public boolean updatePaymentStatus(String transactionId, String newStatus);
    public void deletePayment(String transactionId);
    public List<Payment> getAllPayments();
}
