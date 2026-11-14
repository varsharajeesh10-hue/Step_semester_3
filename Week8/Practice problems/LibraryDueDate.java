import java.util.*;
import java.time.*;

abstract class LibraryItem {
    String title;
    LibraryItem(String t) { title = t; }
    abstract int days();
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int days() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String t) { super(t); }
    int days() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int days() { return 3; }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LocalDate date = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int pos = line.indexOf(' ');
            String type = line.substring(0, pos);
            String title = line.substring(pos + 1).replace("\"", "");

            LibraryItem item;
            if (type.equals("BOOK"))
                item = new Book(title);
            else if (type.equals("DVD"))
                item = new DVD(title);
            else
                item = new Magazine(title);

            System.out.println(title + ": " +
                date.plusDays(item.days()));
        }
    }
}