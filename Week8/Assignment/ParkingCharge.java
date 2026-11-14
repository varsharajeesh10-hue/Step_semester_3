import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int h) { hours = h; }
    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int h) { super(h); }
    double charge() { return hours * 10; }
}

class Car extends Vehicle {
    Car(int h) { super(h); }
    double charge() { return 30 + (hours - 1) * 20; }
}

class Truck extends Vehicle {
    Truck(int h) { super(h); }
    double charge() { return Math.max(100, hours * 50); }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int h = sc.nextInt();

            Vehicle v;
            if (type.equals("BIKE"))
                v = new Bike(h);
            else if (type.equals("CAR"))
                v = new Car(h);
            else
                v = new Truck(h);

            double result = v.charge();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}