interface EmailSender {
    void sendEmail();
}

interface Programmer {
    void code();
}

interface Salesperson {
    void sell();
}

class OfficeEmployee implements EmailSender {
    private String name;

    public OfficeEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " đang gửi email cho khách hàng.");
    }
}

class TechnicalEmployee implements EmailSender, Programmer {
    private String name;

    public TechnicalEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " đang gửi email báo cáo tiến độ.");
    }

    @Override
    public void code() {
        System.out.println(name + " đang lập trình tính năng mới.");
    }
}

class SalesEmployee implements EmailSender, Salesperson {
    private String name;

    public SalesEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " đang gửi email chào hàng.");
    }

    @Override
    public void sell() {
        System.out.println(name + " đang tư vấn và chốt đơn hàng.");
    }
}

public class Main2 {
    public static void main(String[] args) {
        OfficeEmployee officeEmp = new OfficeEmployee("Lan");
        TechnicalEmployee techEmp = new TechnicalEmployee("Minh");
        SalesEmployee salesEmp = new SalesEmployee("Hùng");

        officeEmp.sendEmail();
        System.out.println();

        techEmp.sendEmail();
        techEmp.code();
        System.out.println();

        salesEmp.sendEmail();
        salesEmp.sell();
    }
}
