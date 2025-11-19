package src.payment;

import src.model.Order;

public class MoMoPayment implements Payment {
    private String phoneNumber;

    public MoMoPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(Order order) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("📱 THANH TOÁN QUA MOMO");
        System.out.println("   Số điện thoại: " + phoneNumber);
        System.out.println("   Số tiền: " + String.format("%.2f", order.getTotalAmount()) + " VND");
        order.setPaid(true);
        System.out.println("✓ Thanh toán thành công!");
        System.out.println("═══════════════════════════════════════════");
    }
}
