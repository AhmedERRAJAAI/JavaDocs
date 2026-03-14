package _03_conditionals;

public class IfStatements {
    public static void main(String[] args) {

        // ─── Basic if Statement ───────────────────────────────────────────────────
        System.out.println("=== Basic if ===");
        int temperature = 35;
        if (temperature > 30) {
            System.out.println("It's hot outside. (temperature = " + temperature + ")");
        }

        // ─── if-else Statement ────────────────────────────────────────────────────
        System.out.println("\n=== if-else ===");
        int number = 7;
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        // ─── if-else-if (multi-branch) ────────────────────────────────────────────
        System.out.println("\n=== if-else-if ===");
        int score = 82;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        // ─── Nested if ────────────────────────────────────────────────────────────
        System.out.println("\n=== Nested if ===");
        int age = 20;
        boolean hasId = true;
        if (age >= 18) {
            if (hasId) {
                System.out.println("Access granted — adult with ID.");
            } else {
                System.out.println("Access denied — no ID provided.");
            }
        } else {
            System.out.println("Access denied — under 18.");
        }

        // ─── Logical Operators ────────────────────────────────────────────────────
        System.out.println("\n=== Logical Operators ===");
        int x = 15;
        // AND (&&): both conditions must be true
        if (x > 10 && x < 20) {
            System.out.println(x + " is between 10 and 20 (&&).");
        }
        // OR (||): at least one condition must be true
        if (x < 5 || x > 10) {
            System.out.println(x + " is less than 5 OR greater than 10 (||).");
        }
        // NOT (!): inverts the condition
        boolean isRaining = false;
        if (!isRaining) {
            System.out.println("It is not raining — go for a walk.");
        }

        // ─── Short-Circuit Evaluation ─────────────────────────────────────────────
        System.out.println("\n=== Short-Circuit Evaluation ===");
        // With &&: if the left side is false, the right side is NEVER evaluated.
        // With ||: if the left side is true,  the right side is NEVER evaluated.
        String name = null;
        // Safe null check — without short-circuit, name.length() would throw NullPointerException
        if (name != null && name.length() > 0) {
            System.out.println("Name is non-empty.");
        } else {
            System.out.println("Name is null or empty (short-circuit saved us from NPE).");
        }

        // ─── Ternary Operator ─────────────────────────────────────────────────────
        System.out.println("\n=== Ternary Operator ===");
        // Syntax: condition ? valueIfTrue : valueIfFalse
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("Max of " + a + " and " + b + " is: " + max);

        String parity = (number % 2 == 0) ? "even" : "odd";
        System.out.println(number + " is " + parity);

        // Nested ternary (use sparingly — can hurt readability)
        String category = (score >= 90) ? "Excellent" : (score >= 70) ? "Good" : "Needs Improvement";
        System.out.println("Score " + score + " → " + category);

        // ─── Comparison Operators ─────────────────────────────────────────────────
        System.out.println("\n=== Comparison Operators ===");
        int p = 10, q = 20;
        System.out.println("p == q : " + (p == q));
        System.out.println("p != q : " + (p != q));
        System.out.println("p <  q : " + (p <  q));
        System.out.println("p >  q : " + (p >  q));
        System.out.println("p <= q : " + (p <= q));
        System.out.println("p >= q : " + (p >= q));

        // ─── Comparing Objects ────────────────────────────────────────────────────
        System.out.println("\n=== Comparing Strings (use .equals, not ==) ===");
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("s1 == s2         : " + (s1 == s2));        // false (different objects)
        System.out.println("s1.equals(s2)    : " + s1.equals(s2));     // true  (same content)
        System.out.println("s1.equalsIgnoreCase(\"HELLO\"): " + s1.equalsIgnoreCase("HELLO"));
    }
}
