import java.util.*;

abstract class Room {
    int units;

    Room(int u) { units = u; }
    abstract double bill();
}

class Single extends Room {
    Single(int u) { super(u); }
    double bill() { return units * 8; }
}

class Shared extends Room {
    int occupants;

    Shared(int u, int o) {
        super(u);
        occupants = o;
    }

    double bill() {
        return units * 6.0 / occupants;
    }
}

class AC extends Room {
    AC(int u) { super(u); }
    double bill() { return units * 10 + 200; }
}

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int u = sc.nextInt();

            Room r;
            if (type.equals("SINGLE"))
                r = new Single(u);
            else if (type.equals("SHARED"))
                r = new Shared(u, sc.nextInt());
            else
                r = new AC(u);

            double result = r.bill();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}