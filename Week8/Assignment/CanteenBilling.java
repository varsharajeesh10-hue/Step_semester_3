import java.util.*;

abstract class Customer {
    double amount;

    Customer(double a) { amount = a; }
    abstract double bill();
}

class Student extends Customer {
    Student(double a) { super(a); }
    double bill() { return amount * 0.90; }
}

class Staff extends Customer {
    Staff(double a) { super(a); }
    double bill() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double a) { super(a); }
    double bill() { return amount + 10; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double a = sc.nextDouble();

            Customer c;
            if (type.equals("STUDENT"))
                c = new Student(a);
            else if (type.equals("STAFF"))
                c = new Staff(a);
            else
                c = new Guest(a);

            double result = c.bill();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}