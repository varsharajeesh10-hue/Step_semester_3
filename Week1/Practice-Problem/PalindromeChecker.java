import java.util.Scanner;

public class PalindromeChecker {

    // 1. Iterative approach
    static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // 2. Recursive approach
    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array reversal approach
    static boolean isPalindromeArrayReversal(String text) {

        char[] array = text.toCharArray();

        int start = 0;
        int end = array.length - 1;

        while (start < end) {

            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        String reversed = new String(array);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        if (isPalindromeIterative(text)) {
            System.out.println("Iterative: Palindrome");
        }
        else {
            System.out.println("Iterative: Not Palindrome");
        }

        if (isPalindromeRecursive(text)) {
            System.out.println("Recursive: Palindrome");
        }
        else {
            System.out.println("Recursive: Not Palindrome");
        }

        if (isPalindromeArrayReversal(text)) {
            System.out.println("Array Reversal: Palindrome");
        }
        else {
            System.out.println("Array Reversal: Not Palindrome");
        }
    }
}