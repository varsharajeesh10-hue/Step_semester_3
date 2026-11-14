import java.util.*;
import java.util.regex.*;

abstract class Question {
    String correct, answer;
    double points;

    Question(String c, String a, double p) {
        correct = c;
        answer = a;
        points = p;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) { super(c, a, p); }
    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) { super(c, a, p); }
    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) { super(c, a, p); }

    double grade() {
        int count = 0;
        for (String word : correct.split(",")) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase()))
                count++;
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher m = Pattern.compile("\"([^\"]*)\"").matcher(line);

            String type = line.substring(0, line.indexOf(' '));
            String[] values = new String[3];
            int j = 0;

            while (m.find()) values[j++] = m.group(1);

            double points = Double.parseDouble(
                line.substring(line.lastIndexOf('"') + 1).trim());

            Question q;
            if (type.equals("MCQ"))
                q = new MCQ(values[1], values[2], points);
            else if (type.equals("TF"))
                q = new TF(values[1], values[2], points);
            else
                q = new Essay(values[1], values[2], points);

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}