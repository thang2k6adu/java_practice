abstract class Employee {
    protected String name;
    protected int age;
    protected double salary;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void calculateSalary();

    public void displayInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Lương: " + salary);
        System.out.println("--------------------");
    }
}

class OfficeEmployee extends Employee {
    private int workingDays;
    private static final double DAILY_RATE = 100; // cố định

    public OfficeEmployee(String name, int age, int workingDays) {
        super(name, age);
        this.workingDays = workingDays;
    }

    @Override
    public void calculateSalary() {
        salary = workingDays * DAILY_RATE;
    }
}

class TechnicalEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public TechnicalEmployee(String name, int age, int workingHours, double hourlyRate) {
        super(name, age);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculateSalary() {
        salary = workingHours * hourlyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        OfficeEmployee officeEmp = new OfficeEmployee("An", 28, 22);
        TechnicalEmployee techEmp = new TechnicalEmployee("Bình", 30, 160, 15);

        officeEmp.calculateSalary();
        techEmp.calculateSalary();

        officeEmp.displayInfo();
        techEmp.displayInfo();
    }
}
