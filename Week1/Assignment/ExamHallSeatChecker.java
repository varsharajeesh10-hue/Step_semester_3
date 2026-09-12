import java.util.Scanner;

public class ExamHallSeatChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    System.out.println("Duplicate Seat Number Found: "
                            + seatNumbers[i]);

                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] seats = new int[5];

        System.out.println("Enter 5 seat numbers:");

        for (int i = 0; i < seats.length; i++) {
            seats[i] = sc.nextInt();
        }

        checkDuplicateSeats(seats);
    }
}