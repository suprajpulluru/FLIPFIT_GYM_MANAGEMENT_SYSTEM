package com.flipfit.bean;

public class FlipFitPayment {
    private String transactionId;
    private String bookingId;
    private String paymentStatus;
    private String paymentMethod;
    private String paymentMethodId;

    public FlipFitPayment() {
        super();
    }

    public FlipFitPayment(String transactionId, String bookingId, String paymentStatus, String paymentMethod, String paymentMethodId) {
        this.transactionId = transactionId;
        this.bookingId = bookingId;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.paymentMethodId = paymentMethodId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
