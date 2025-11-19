package src.payment;

import src.model.Order;

public class CashPayment implements Payment {
    
    @Override
    public void pay(Order order) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("💵 THANH TOÁN BẰNG TIỀN MẶT");
        System.out.println("   Số tiền: " + String.format("%.2f", order.getTotalAmount()) + " VND");
        order.setPaid(true);
        System.out.println("✓ Thanh toán thành công!");
        System.out.println("═══════════════════════════════════════════");
    }
}
