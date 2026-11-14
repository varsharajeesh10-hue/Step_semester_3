import java.util.*;
import java.time.*;

abstract class Plan {
    String name;
    LocalDate start;

    Plan(String n, String d) {
        name = n;
        start = LocalDate.parse(d);
    }

    abstract int validity();

    LocalDate renewalDate() {
        return start.plusDays(validity());
    }
}

class Basic extends Plan {
    Basic(String n, String d) { super(n, d); }
    int validity() { return 30; }
}

class Standard extends Plan {
    Standard(String n, String d) { super(n, d); }
    int validity() { return 90; }
}

class Premium extends Plan {
    Premium(String n, String d) { super(n, d); }
    int validity() { return 365; }
}

public class RenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Plan p;
            if (type.equals("BASIC"))
                p = new Basic(name, date);
            else if (type.equals("STANDARD"))
                p = new Standard(name, date);
            else
                p = new Premium(name, date);

            System.out.println(name + ": " + p.renewalDate());
        }
    }
}