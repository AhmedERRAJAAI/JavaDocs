package userinput;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ─── Reading Different Types ───────────────────────────────────────────
        System.out.println("=== Reading Different Types ===");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();   // reads entire line including spaces

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();        // reads the next int token

        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble(); // reads the next double token

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean(); // reads next boolean token

        System.out.printf("%nHello, %s!%n", name);
        System.out.printf("Age: %d, Height: %.2f m, Student: %b%n", age, height, isStudent);

        // ─── nextLine() After nextInt() Problem ────────────────────────────────
        // After reading a number with nextInt()/nextDouble(), a leftover newline
        // remains in the buffer. The next nextLine() call will consume it and
        // return an empty string. Fix: call nextLine() once to consume it.
        scanner.nextLine();  // consume the leftover newline from nextBoolean()

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();  // now works correctly
        System.out.println("You entered: " + sentence);

        // ─── Reading Multiple Values on One Line ───────────────────────────────
        System.out.println("\n=== Reading Multiple Values (space-separated) ===");
        System.out.print("Enter two numbers separated by a space: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Sum: " + (x + y));
        scanner.nextLine(); // consume leftover newline

        // ─── Reading in a Loop Until Sentinel ─────────────────────────────────
        System.out.println("\n=== Loop Until Sentinel (enter -1 to stop) ===");
        int sum = 0;
        int count = 0;
        System.out.println("Enter integers one by one (-1 to stop):");
        int input = scanner.nextInt();
        while (input != -1) {
            sum += input;
            count++;
            input = scanner.nextInt();
        }
        System.out.println("Count: " + count + ", Sum: " + sum);
        if (count > 0) {
            System.out.printf("Average: %.2f%n", (double) sum / count);
        }
        scanner.nextLine(); // consume leftover newline

        // ─── hasNextXxx — Check Before Reading ────────────────────────────────
        System.out.println("\n=== hasNextInt() Validation ===");
        System.out.print("Enter an integer: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not an integer. Try again: ");
            scanner.next();   // discard the invalid token
        }
        int validInt = scanner.nextInt();
        System.out.println("Valid integer: " + validInt);
        scanner.nextLine();

        // ─── Reading a Full Block of Lines ────────────────────────────────────
        System.out.println("\n=== Reading Multiple Lines (empty line to stop) ===");
        System.out.println("Type lines of text. Press Enter on an empty line to finish:");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            sb.append(line).append("\n");
        }
        System.out.println("You entered:\n" + sb);

        // ─── close() the Scanner ──────────────────────────────────────────────
        scanner.close();   // releases the underlying System.in resource
        System.out.println("Scanner closed. Program complete.");
    }
}
