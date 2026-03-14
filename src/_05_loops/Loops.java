package _05_loops;

public class Loops {
    public static void main(String[] args) {

        // ─── for Loop ─────────────────────────────────────────────────────────────
        System.out.println("=== for Loop ===");
        // Syntax: for (init; condition; update)
        for (int i = 0; i < 5; i++) {
            System.out.println("  i = " + i);
        }

        // Counting backwards
        System.out.println("Counting down:");
        for (int i = 5; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // ─── while Loop ───────────────────────────────────────────────────────────
        System.out.println("\n=== while Loop ===");
        // Checks condition BEFORE executing body. May run 0 times.
        int j = 1;
        int sum = 0;
        while (j <= 10) {
            sum += j;
            j++;
        }
        System.out.println("Sum of 1 to 10 = " + sum);

        // ─── do-while Loop ────────────────────────────────────────────────────────
        System.out.println("\n=== do-while Loop ===");
        // Checks condition AFTER executing body. Always runs at least once.
        int k = 0;
        do {
            System.out.println("  do-while iteration: " + k);
            k++;
        } while (k < 3);

        // Demonstrates "at least once": condition is false from the start
        int count = 10;
        do {
            System.out.println("  This runs even though count=" + count + " >= 10");
            count++;
        } while (count < 10);

        // ─── Enhanced for Loop (for-each) ─────────────────────────────────────────
        System.out.println("\n=== Enhanced for Loop (for-each) ===");
        // Read-only iteration over arrays and Iterable collections.
        int[] numbers = {10, 20, 30, 40, 50};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits) {
            System.out.println("  Fruit: " + fruit);
        }

        // ─── break Statement ──────────────────────────────────────────────────────
        System.out.println("\n=== break ===");
        // Exits the loop immediately when a condition is met.
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("  Breaking at i = " + i);
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // ─── continue Statement ───────────────────────────────────────────────────
        System.out.println("\n=== continue ===");
        // Skips the rest of the current iteration and moves to the next.
        System.out.println("Odd numbers from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;   // skip even numbers
            System.out.print(i + " ");
        }
        System.out.println();

        // ─── Nested Loops ─────────────────────────────────────────────────────────
        System.out.println("\n=== Nested Loops ===");
        // Multiplication table (3×3)
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();
        }

        // ─── Labeled break (exits outer loop) ────────────────────────────────────
        System.out.println("\n=== Labeled break ===");
        outer:
        for (int i = 0; i < 3; i++) {
            for (int inner = 0; inner < 3; inner++) {
                if (i == 1 && inner == 1) {
                    System.out.println("  Breaking outer loop at i=" + i + ", inner=" + inner);
                    break outer;   // exits both loops
                }
                System.out.println("  i=" + i + " inner=" + inner);
            }
        }

        // ─── Infinite Loop with break ─────────────────────────────────────────────
        System.out.println("\n=== Controlled Infinite Loop ===");
        int value = 1;
        while (true) {
            if (value > 4) break;
            System.out.print(value + " ");
            value *= 2;
        }
        System.out.println();

        // ─── Iterating an Array with Index ────────────────────────────────────────
        System.out.println("\n=== Array with Index ===");
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        for (int i = 0; i < days.length; i++) {
            System.out.println("  Day " + (i + 1) + ": " + days[i]);
        }
    }
}
