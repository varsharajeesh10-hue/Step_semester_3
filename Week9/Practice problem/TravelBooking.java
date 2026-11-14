import java.util.*;

abstract class Booking {
    double distance;
    static final double FEE = 50;

    Booking(double d) { distance = d; }
    abstract double baseFare();

    double totalFare() {
        return baseFare() + FEE;
    }
}

class Bus extends Booking {
    Bus(double d) { super(d); }
    double baseFare() { return distance * 2; }
}

class Train extends Booking {
    Train(double d) { super(d); }
    double baseFare() { return distance * 1.5; }
}

class Flight extends Booking {
    Flight(double d) { super(d); }
    double baseFare() { return 2500 + distance * 4; }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double d = sc.nextDouble();

            Booking b;
            if (type.equals("BUS"))
                b = new Bus(d);
            else if (type.equals("TRAIN"))
                b = new Train(d);
            else
                b = new Flight(d);

            System.out.printf("%s: %.2f%n", type, b.totalFare());
        }
    }
}