import java.io.*; //File, FileReader, FileWriter, BufferedReader, BufferedWriter, InputStream, OutputStream, …
import java.util.*; // Scanner ArrayLít, HashMap, HashSet, Date, Calendar
import vn.edu.ptit.*; //import các class trong jar (Student, Subject, Rule và Invoice)
import view.*;

public class HELLLOJAR {
  static class PaymentController {
    private Invoice invoice;

    // đặt là controller vì MVC thì controller xử lý logic
    public PaymentController() {
      Scanner sc = new Scanner(System.in);

      Student st = new Student(sc.nextLine(), sc.nextLine());

      int nSubject = Integer.parseInt(sc.nextLine());
      ArrayList<Subject> AllSubject = new ArrayList<>();

      for (int i = 0; i < nSubject; i++) {
        String code = sc.nextLine();
        String name = sc.nextLine();
        // credit in this case is so tin chi
        AllSubject.add(new Subject(name, code, Integer.parseInt(sc.nextLine())));
      }

      Rule rule = new Rule(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));

      invoice = new Invoice(rule);
      invoice.setSt(st);
      invoice.setAlSubject(AllSubject);
      double amount = 0;
      for (Subject sj : AllSubject) {
        amount += sj.getCredit() * rule.getCreditPrice();
      }
      ;
      invoice.setAmount(amount);

      sc.close();
    }

    public Invoice getInvoice() {
      return invoice;
    }
  }

  public static void main(String[] args) {
    PaymentController pc = new PaymentController();

    Invoice invoice = pc.getInvoice();
    InvoiceView.show(invoice);
  } 
}