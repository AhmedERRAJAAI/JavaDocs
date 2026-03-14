package datatypes;

public class DataTypes {
    public static void main(String[] args) {

        // ─── Primitive Data Types ────────────────────────────────────────────────────

        // byte: 8-bit signed integer (-128 to 127). Useful when memory is tight.
        byte byteVal = 100;
        System.out.println("byte: " + byteVal
                + "  (range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE + ")");

        // short: 16-bit signed integer (-32,768 to 32,767).
        short shortVal = 30_000;   // underscores improve readability in large numbers
        System.out.println("short: " + shortVal
                + "  (range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE + ")");

        // int: 32-bit signed integer – the default integer type in Java.
        int age = 21;
        System.out.println("int: " + age
                + "  (range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE + ")");

        // long: 64-bit signed integer. Append L to the literal to avoid compiler error.
        long worldPopulation = 8_100_000_000L;
        System.out.println("long: " + worldPopulation
                + "  (range: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE + ")");

        // float: 32-bit floating-point. Append f. Less precise than double.
        float pi = 3.14159f;
        System.out.println("float: " + pi);

        // double: 64-bit floating-point – default for decimal literals. Preferred over float.
        double price = 19.99;
        System.out.println("double: " + price);

        // char: single 16-bit Unicode character. Written in single quotes.
        char grade      = 'A';
        char newline    = '\n';   // escape sequence
        char smiley     = '\u263A'; // Unicode code point
        System.out.println("char: " + grade + "  unicode smiley: " + smiley);

        // boolean: exactly true or false. Cannot be cast to/from integers (unlike C/C++).
        boolean isStudent = true;
        boolean isPassing = age >= 18;
        System.out.println("boolean isStudent: " + isStudent + "  isPassing: " + isPassing);

        // ─── Type Casting ────────────────────────────────────────────────────────────

        // Widening (implicit): smaller → larger type – safe, no data loss.
        int intVal = 42;
        double wideDouble = intVal;
        System.out.println("\nWidening cast  int → double: " + wideDouble);

        // Narrowing (explicit): larger → smaller type – you must cast explicitly; data may be lost.
        double gpa = 3.99;
        int truncated = (int) gpa;   // decimal portion is simply dropped
        System.out.println("Narrowing cast double → int: " + truncated + "  (decimal lost)");

        // char ↔ int: a char is really a number under the hood.
        char letter = 'Z';
        int  ascii  = letter;
        System.out.println("char 'Z' as int: " + ascii);
        System.out.println("int 65 as char: " + (char) 65);

        // ─── Reference Data Types ────────────────────────────────────────────────────

        // String: an immutable sequence of characters. Lives on the heap.
        String name = "John Doe";
        System.out.println("\nString: \"" + name + "\"  length: " + name.length());

        // String literals are interned – two identical literals share the same object.
        String a = "hello";
        String b = "hello";
        String c = new String("hello");   // forces a new object on the heap
        System.out.println("a == b (same literal): " + (a == b));
        System.out.println("a == c (new object):   " + (a == c));
        System.out.println("a.equals(c):           " + a.equals(c));

        // Arrays: fixed-size ordered collection of elements of the same type.
        int[]    numbers = {10, 20, 30, 40, 50};
        String[] fruits  = new String[3];
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Cherry";

        System.out.print("\nint[] numbers: ");
        for (int n : numbers) System.out.print(n + " ");
        System.out.println();
        System.out.print("String[] fruits: ");
        for (String f : fruits) System.out.print(f + " ");
        System.out.println();

        // null: the default value for any uninitialized reference type.
        String empty = null;
        System.out.println("null reference: " + empty);

        // ─── Wrapper Classes & Autoboxing ────────────────────────────────────────────

        // Every primitive has a corresponding wrapper class in java.lang.
        Integer boxedInt    = age;              // autoboxing: int → Integer
        int     unboxedInt  = boxedInt;         // unboxing:   Integer → int
        Double  boxedDouble = price;            // autoboxing: double → Double

        System.out.println("\nAutoboxed Integer: " + boxedInt);
        System.out.println("Unboxed int:       " + unboxedInt);

        // Wrapper classes provide useful utility methods.
        System.out.println("Integer.parseInt(\"42\"): " + Integer.parseInt("42"));
        System.out.println("Integer.toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Double.isNaN(0.0/0.0): " + Double.isNaN(0.0 / 0.0));
    }
}
