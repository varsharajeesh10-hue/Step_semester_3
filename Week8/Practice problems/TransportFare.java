import java.util.*;

abstract class Transport {
    double distance;

    Transport(double d) { distance = d; }
    abstract double fare();
}

class Bus extends Transport {
    Bus(double d) { super(d); }
    double fare() {
        return Math.min(2 + 0.1 * distance, 10);
    }
}

class Train extends Transport {
    Train(double d) { super(d); }
    double fare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double d, double f) {
        super(d);
        factor = f;
    }

    double fare() {
        return (1.5 + 0.2 * distance) * factor;
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double d = sc.nextDouble();

            Transport t;
            if (type.equals("BUS"))
                t = new Bus(d);
            else if (type.equals("TRAIN"))
                t = new Train(d);
            else
                t = new Metro(d, sc.nextDouble());

            double result = t.fare();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}