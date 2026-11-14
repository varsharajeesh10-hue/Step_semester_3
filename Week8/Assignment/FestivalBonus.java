import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String n, double s) {
        name = n;
        salary = s;
    }

    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee e;
            if (type.equals("FULLTIME"))
                e = new FullTime(name, salary);
            else if (type.equals("PARTTIME"))
                e = new PartTime(name, salary);
            else
                e = new Intern(name, salary);

            double result = e.bonus();
            System.out.printf("%s: %.2f%n", name, result);
            total += result;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}