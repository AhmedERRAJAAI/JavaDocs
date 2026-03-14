package _06_methods;

public class Methods {

    // ─── Access Modifiers ─────────────────────────────────────────────────────
    private static int privateCounter = 0;          // visible only inside this class
    static int packageCounter = 0;                   // visible within the same package (default/package-private)
    protected static int protectedCounter = 0;       // visible in same package + subclasses
    public static int publicCounter = 0;             // visible everywhere

    // ─── Basic Method ─────────────────────────────────────────────────────────
    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // ─── Return Value ─────────────────────────────────────────────────────────
    static int add(int a, int b) {
        return a + b;
    }

    // ─── Method Overloading ───────────────────────────────────────────────────
    // Same name, different parameter types — resolved at compile time.
    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // ─── Varargs (Variable-Length Arguments) ──────────────────────────────────
    // Allows passing any number of arguments of the same type.
    // Under the hood, args is treated as an array.
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // ─── Recursion ────────────────────────────────────────────────────────────
    // A method that calls itself. Must have a base case to terminate.
    static long factorial(int n) {
        if (n < 0)  throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return 1;          // base case
        return n * factorial(n - 1);   // recursive call
    }

    static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ─── Method with Multiple Return Points ───────────────────────────────────
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // ─── Pass by Value ────────────────────────────────────────────────────────
    // Java is ALWAYS pass-by-value.
    // For primitives: a copy of the value is passed — original is NOT modified.
    // For objects:    a copy of the REFERENCE is passed — the object can be modified,
    //                 but reassigning the parameter won't affect the caller.
    static void tryToModify(int x) {
        x = 999;   // only modifies local copy
    }

    static void modifyArray(int[] arr) {
        arr[0] = 999;   // modifies the actual array (via the copied reference)
    }

    // ─── Protected Method Demo ────────────────────────────────────────────────
    protected static void protectedMethod() {
        System.out.println("protectedMethod() called — accessible within package and subclasses.");
    }

    // ─── Private Helper ───────────────────────────────────────────────────────
    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // ─── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // Basic method call
        System.out.println("=== Basic Method ===");
        greet("Alice");

        // Return value
        System.out.println("\n=== Return Value ===");
        int result = add(5, 10);
        System.out.println("add(5, 10) = " + result);

        // Overloaded methods
        System.out.println("\n=== Method Overloading ===");
        System.out.println("add(int, int)        = " + add(3, 4));
        System.out.println("add(double, double)  = " + add(3.5, 4.5));
        System.out.println("add(int, int, int)   = " + add(1, 2, 3));

        // Varargs
        System.out.println("\n=== Varargs ===");
        System.out.println("sum()           = " + sum());
        System.out.println("sum(1)          = " + sum(1));
        System.out.println("sum(1,2,3,4,5)  = " + sum(1, 2, 3, 4, 5));

        // Recursion
        System.out.println("\n=== Recursion ===");
        for (int i = 0; i <= 7; i++) {
            System.out.println("factorial(" + i + ") = " + factorial(i));
        }
        System.out.print("Fibonacci sequence (10 terms): ");
        for (int i = 0; i < 10; i++) System.out.print(fibonacci(i) + " ");
        System.out.println();

        // isPrime
        System.out.println("\n=== isPrime ===");
        int[] testNums = {1, 2, 3, 4, 13, 17, 20, 29, 97};
        for (int n : testNums) {
            System.out.println("isPrime(" + n + ") = " + isPrime(n));
        }

        // Pass by value
        System.out.println("\n=== Pass by Value ===");
        int original = 42;
        tryToModify(original);
        System.out.println("After tryToModify(" + original + "): " + original + "  (unchanged)");

        int[] arr = {1, 2, 3};
        modifyArray(arr);
        System.out.println("After modifyArray: arr[0] = " + arr[0] + "  (changed via reference)");

        // Access modifiers
        System.out.println("\n=== Access Modifiers ===");
        protectedMethod();
        System.out.println("publicCounter accessible everywhere: " + publicCounter);
        // privateCounter is NOT accessible outside this class
        // It IS accessible here because we're still inside Methods:
        privateCounter++;
        System.out.println("privateCounter (only accessible here): " + privateCounter);

        // Private helper used internally
        System.out.println("\n=== Private Helper ===");
        System.out.println("isEven(4) = " + isEven(4));
        System.out.println("isEven(7) = " + isEven(7));
    }
}
