package app.entity;

import app.entity.interfaces.Billable;
import app.enums.PaymentMethod;
import app.enums.PaymentStatus;
import java.util.Date;

public class Payment implements Billable {

    private int paymentId;
    private double amount;
    private PaymentMethod paymentMethod;
    private Date paymentDate;
    private PaymentStatus status;
    private Booking booking;

    public Payment(int paymentId, double amount, PaymentMethod paymentMethod) {
        this.paymentId     = paymentId;
        this.amount        = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate   = null;
        this.status        = PaymentStatus.PENDING;
        this.booking       = null;
    }

    // Validates the booking + amount + method, sets the status accordingly,
    // and stamps the payment date if everything checks out.
    public void processPayment(Booking booking) {
        try {
            if (booking == null) {
                status = PaymentStatus.FAILED;
                System.out.println("Payment failed: no booking provided.");
                return;
            }

            this.booking = booking;
            double bookingTotal = booking.calculateBill();

            if (bookingTotal <= 0) {
                status = PaymentStatus.FAILED;
                System.out.println("Payment failed: booking bill is zero or invalid.");
                return;
            }

            if (amount <= 0 || paymentMethod == null) {
                status = PaymentStatus.FAILED;
                System.out.println("Payment failed: invalid amount or missing payment method.");
                return;
            }

            if (amount < bookingTotal) {
                status = PaymentStatus.FAILED;
                System.out.println("Payment failed: amount $" + amount
                        + " is less than the required total of $" + bookingTotal + ".");
                return;
            }

            this.paymentDate = new Date();
            this.status      = PaymentStatus.SUCCESS;
            System.out.println("Payment of $" + amount
                    + " processed successfully for booking #"
                    + booking.getBookingId() + ".");

        } catch (Exception e) {
            status = PaymentStatus.FAILED;
            System.out.println("Payment error: " + e.getMessage());
        }
    }

    @Override
    public double calculateBill() {
        return amount;
    }

    @Override
    public void printBill() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "========== PAYMENT RECEIPT ==========\n"
                + "Payment ID     : " + paymentId   + "\n"
                + "Booking ID     : " + (booking != null ? booking.getBookingId() : "N/A") + "\n"
                + "Amount Paid    : $" + amount      + "\n"
                + "Payment Method : " + paymentMethod + "\n"
                + "Payment Date   : " + (paymentDate != null ? paymentDate : "Not processed") + "\n"
                + "Status         : " + status       + "\n"
                + "=====================================";
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
