package src.payment;

import src.model.Order;

public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(Order order) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("💳 THANH TOÁN QUA THẺ TÍN DỤNG");
        System.out.println("   Chủ thẻ: " + cardHolder);
        System.out.println("   Số thẻ: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("   Số tiền: " + String.format("%.2f", order.getTotalAmount()) + " VND");
        order.setPaid(true);
        System.out.println("✓ Thanh toán thành công!");
        System.out.println("═══════════════════════════════════════════");
    }
}
