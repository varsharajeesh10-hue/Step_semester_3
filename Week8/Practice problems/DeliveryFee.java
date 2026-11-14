import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double w, double d) {
        weight = w;
        distance = d;
    }

    abstract double fee();
}

class Standard extends Delivery {
    Standard(double w, double d) { super(w, d); }
    double fee() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }
}

class Express extends Delivery {
    Express(double w, double d) { super(w, d); }
    double fee() {
        return 15 + weight + 0.2 * distance;
    }
}

class International extends Delivery {
    double customs;

    International(double w, double d, double c) {
        super(w, d);
        customs = c;
    }

    double fee() {
        return 25 + 2 * weight + 0.5 * distance + customs;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double d = sc.nextDouble();

            Delivery obj;
            if (type.equals("STANDARD"))
                obj = new Standard(w, d);
            else if (type.equals("EXPRESS"))
                obj = new Express(w, d);
            else {
                double c = sc.nextDouble();
                obj = new International(w, d, c);
            }

            double result = obj.fee();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}