package _02_operators;

public class ArithmeticOperators {
    public static void main(String[] args) {

        int a = 10, b = 3;

        // ─── Basic Arithmetic ─────────────────────────────────────────────────────

        System.out.println("=== Basic Arithmetic ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b  = " + (a + b));   // Addition
        System.out.println("a - b  = " + (a - b));   // Subtraction
        System.out.println("a * b  = " + (a * b));   // Multiplication
        System.out.println("a / b  = " + (a / b));   // Integer division (truncates)
        System.out.println("a % b  = " + (a % b));   // Modulus (remainder)

        // ─── Integer vs Floating-Point Division ──────────────────────────────────

        System.out.println("\n=== Integer vs Floating-Point Division ===");
        System.out.println("10 / 3   = " + (10 / 3));          // → 3  (integer division)
        System.out.println("10.0 / 3 = " + (10.0 / 3));        // → 3.333… (double division)
        System.out.println("(double) 10 / 3 = " + ((double) 10 / 3)); // cast first, then divide

        // ─── Modulus (%) ──────────────────────────────────────────────────────────

        System.out.println("\n=== Modulus Examples ===");
        System.out.println("Is 10 even? " + (10 % 2 == 0));  // true
        System.out.println("Is 7  odd?  " + (7  % 2 != 0));  // true
        System.out.println("Minutes in 150 seconds: " + (150 / 60) + " min " + (150 % 60) + " sec");

        // ─── Increment & Decrement ────────────────────────────────────────────────

        System.out.println("\n=== Increment & Decrement ===");
        int x = 5;
        System.out.println("x = " + x);

        // Pre-increment: increment THEN use the value
        System.out.println("++x = " + (++x));   // x becomes 6, prints 6
        // Post-increment: use the value THEN increment
        System.out.println("x++ = " + (x++));   // prints 6, x becomes 7
        System.out.println("x after x++ = " + x);  // 7

        // Pre-decrement / Post-decrement work the same way
        System.out.println("--x = " + (--x));   // x becomes 6, prints 6
        System.out.println("x-- = " + (x--));   // prints 6, x becomes 5
        System.out.println("x after x-- = " + x);  // 5

        // ─── Compound Assignment Operators ────────────────────────────────────────

        System.out.println("\n=== Compound Assignment ===");
        int n = 20;
        System.out.println("n = " + n);
        n += 5;  System.out.println("n += 5  → " + n);  // 25
        n -= 3;  System.out.println("n -= 3  → " + n);  // 22
        n *= 2;  System.out.println("n *= 2  → " + n);  // 44
        n /= 4;  System.out.println("n /= 4  → " + n);  // 11
        n %= 4;  System.out.println("n %= 4  → " + n);  //  3

        // ─── Operator Precedence ─────────────────────────────────────────────────

        System.out.println("\n=== Operator Precedence ===");
        int result1 = 2 + 3 * 4;         // → 14  (* before +)
        int result2 = (2 + 3) * 4;       // → 20  (parentheses first)
        int result3 = 10 - 2 + 3;        // → 11  (left-to-right for same precedence)
        int result4 = 2 * 3 + 4 / 2;     // → 8   (both * and / before +)
        System.out.println("2 + 3 * 4      = " + result1);
        System.out.println("(2 + 3) * 4    = " + result2);
        System.out.println("10 - 2 + 3     = " + result3);
        System.out.println("2 * 3 + 4 / 2  = " + result4);

        // ─── Overflow & Underflow ────────────────────────────────────────────────

        System.out.println("\n=== Overflow & Underflow ===");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE         = " + maxInt);
        System.out.println("Integer.MAX_VALUE + 1     = " + (maxInt + 1));  // wraps to MIN_VALUE
        System.out.println("Integer.MIN_VALUE - 1     = " + (Integer.MIN_VALUE - 1)); // wraps to MAX_VALUE

        // Use long to avoid overflow
        long bigProduct = (long) maxInt * 2;
        System.out.println("(long) MAX_VALUE * 2      = " + bigProduct);  // correct result

        // ─── Math Class Utilities ────────────────────────────────────────────────

        System.out.println("\n=== Math Class ===");
        System.out.println("Math.abs(-7)       = " + Math.abs(-7));
        System.out.println("Math.pow(2, 10)    = " + (int) Math.pow(2, 10));
        System.out.println("Math.sqrt(144)     = " + Math.sqrt(144));
        System.out.println("Math.max(18, 25)   = " + Math.max(18, 25));
        System.out.println("Math.min(18, 25)   = " + Math.min(18, 25));
        System.out.println("Math.round(3.7)    = " + Math.round(3.7));
        System.out.println("Math.floor(3.9)    = " + Math.floor(3.9));
        System.out.println("Math.ceil(3.1)     = " + Math.ceil(3.1));
        System.out.println("Math.random() (0–1): " + Math.random());
    }
}
