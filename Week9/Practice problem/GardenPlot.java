import java.util.*;

abstract class Plot {
    String owner;
    Plot(String o) { owner = o; }
    abstract double area();
}

class Circle extends Plot {
    double r;
    Circle(String o, double r) {
        super(o);
        this.r = r;
    }
    double area() { return Math.PI * r * r; }
}

class Rectangle extends Plot {
    double l, w;
    Rectangle(String o, double l, double w) {
        super(o);
        this.l = l;
        this.w = w;
    }
    double area() { return l * w; }
}

class Triangle extends Plot {
    double b, h;
    Triangle(String o, double b, double h) {
        super(o);
        this.b = b;
        this.h = h;
    }
    double area() { return 0.5 * b * h; }
}

public class GardenPlot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Plot p;

            if (type.equals("CIRCLE"))
                p = new Circle(name, sc.nextDouble());
            else if (type.equals("RECTANGLE"))
                p = new Rectangle(name, sc.nextDouble(), sc.nextDouble());
            else
                p = new Triangle(name, sc.nextDouble(), sc.nextDouble());

            double a = p.area();
            System.out.printf("%s (%s): %.2f%n", name, type, a);
            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
    }
}