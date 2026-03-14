package output;

public class Printf {
    public static void main(String[] args) {

        // ─── Basic printf ──────────────────────────────────────────────────────
        System.out.println("=== Basic printf ===");
        String name = "Alice";
        int age = 30;
        double gpa = 3.75;

        // Syntax: %[flags][width][.precision][conversion]
        System.out.printf("Hello, %s! You are %d years old and your GPA is %.2f.%n", name, age, gpa);

        // ─── String Formatting (%s) ────────────────────────────────────────────
        System.out.println("\n=== String Specifier (%s) ===");
        System.out.printf("Name    : %s%n",    "Bob");
        System.out.printf("Upper   : %S%n",    "hello");       // %S → uppercase
        System.out.printf("Width 10: '%10s'%n", "hi");         // right-aligned in 10 chars
        System.out.printf("Left-10 : '%-10s'%n", "hi");        // left-aligned (flag -)
        System.out.printf("Null    : %s%n",    (Object) null);  // prints "null"

        // ─── Integer Formatting (%d) ───────────────────────────────────────────
        System.out.println("\n=== Integer Specifier (%d) ===");
        int n = 42;
        System.out.printf("Default       : %d%n",   n);
        System.out.printf("Width 8       : '%8d'%n",  n);   // right-aligned, padded with spaces
        System.out.printf("Zero-padded   : '%08d'%n", n);   // padded with zeros
        System.out.printf("Left-aligned  : '%-8d'%n", n);   // left-aligned
        System.out.printf("With +        : '%+d'%n",  n);   // always show sign
        System.out.printf("With +neg     : '%+d'%n",  -n);
        System.out.printf("Grouped (,)   : '%,d'%n",  1_000_000); // thousands separator

        // ─── Floating-Point Formatting (%f, %e, %g) ───────────────────────────
        System.out.println("\n=== Floating-Point Specifiers ===");
        double pi = Math.PI;
        System.out.printf("Default %%f    : %f%n",    pi);
        System.out.printf(".2f            : %.2f%n",   pi);   // 2 decimal places
        System.out.printf(".5f            : %.5f%n",   pi);   // 5 decimal places
        System.out.printf("Width 10.3f    : '%10.3f'%n", pi); // total width 10, 3 decimals
        System.out.printf("%%e (scientific): %e%n",    pi);   // scientific notation
        System.out.printf("%%g (auto)      : %g%n",    pi);   // shorter of %%f and %%e

        // ─── Other Specifiers ─────────────────────────────────────────────────
        System.out.println("\n=== Other Specifiers ===");
        System.out.printf("char   %%c : %c%n",  'J');          // character
        System.out.printf("boolean %%b: %b%n",  true);         // boolean
        System.out.printf("hex  %%x   : %x%n",  255);          // hexadecimal lowercase
        System.out.printf("HEX  %%X   : %X%n",  255);          // hexadecimal uppercase
        System.out.printf("octal %%o  : %o%n",  8);            // octal
        System.out.printf("percent%%%%: 100%%%n");              // literal percent sign

        // ─── Newline & Tab ────────────────────────────────────────────────────
        System.out.println("\n=== Escape Sequences ===");
        System.out.printf("Tab:\\there%n");
        System.out.printf("Newline:\\nSecond line%n");
        // %n vs \n: %n is platform-independent newline; prefer %n in printf

        // ─── String.format ────────────────────────────────────────────────────
        // Same format specifiers, but returns a String instead of printing.
        System.out.println("\n=== String.format ===");
        String formatted = String.format("%-10s | %5d | %.2f", "Alice", 95, 4.00);
        System.out.println(formatted);
        formatted = String.format("%-10s | %5d | %.2f", "Bob", 78, 3.25);
        System.out.println(formatted);
        formatted = String.format("%-10s | %5d | %.2f", "Charlie", 88, 3.75);
        System.out.println(formatted);

        // ─── Formatted Table ─────────────────────────────────────────────────
        System.out.println("\n=== Formatted Table ===");
        System.out.printf("%-12s %6s %8s%n", "Product", "Units", "Price");
        System.out.printf("%-12s %6d %8.2f%n", "Apple",  150, 0.99);
        System.out.printf("%-12s %6d %8.2f%n", "Banana",  75, 0.49);
        System.out.printf("%-12s %6d %8.2f%n", "Cherry", 200, 3.49);
    }
}
