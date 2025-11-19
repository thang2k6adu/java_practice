package src.payment;

import src.model.Order;

public class PaypalPayment implements Payment {
    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(Order order) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("💰 THANH TOÁN QUA PAYPAL");
        System.out.println("   Email: " + email);
        System.out.println("   Số tiền: " + String.format("%.2f", order.getTotalAmount()) + " VND");
        order.setPaid(true);
        System.out.println("✓ Thanh toán thành công!");
        System.out.println("═══════════════════════════════════════════");
    }
}
