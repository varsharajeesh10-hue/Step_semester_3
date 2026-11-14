import java.util.*;

interface SaverMode {
}

abstract class Appliance {
    double hours;

    Appliance(double h) { hours = h; }
    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost(double u) {
        return u * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    double power() { return 150; }
}

class AC extends Appliance implements SaverMode {
    AC(double h) { super(h); }
    double power() { return 1500; }
}

class TV extends Appliance {
    TV(double h) { super(h); }
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) { super(h); }
    double power() { return 500; }
}

public class ApplianceEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double h = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver) sc.next();

            Appliance a;
            if (type.equals("FRIDGE"))
                a = new Fridge(h);
            else if (type.equals("AC"))
                a = new AC(h);
            else if (type.equals("TV"))
                a = new TV(h);
            else
                a = new Washer(h);

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double u = a.units();

            if (saver)
                u = u * 0.75;

            double c = a.cost(u);

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    type, u, c);

            total += c;
        }

        System.out.printf("Total Cost: %.2f%n", total);
    }
}