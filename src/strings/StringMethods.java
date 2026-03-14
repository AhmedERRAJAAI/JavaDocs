package strings;

public class StringMethods {
    public static void main(String[] args) {

        // ─── String Creation ──────────────────────────────────────────────────
        System.out.println("=== String Creation ===");
        String s1 = "Hello, World!";        // string literal (interned)
        String s2 = new String("Hello!");   // new object on the heap (avoid this)
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        // ─── Length & Emptiness ───────────────────────────────────────────────
        System.out.println("\n=== Length & Emptiness ===");
        String empty = "";
        String blank = "   ";
        System.out.println("s1.length()          = " + s1.length());
        System.out.println("empty.isEmpty()      = " + empty.isEmpty());
        System.out.println("blank.isEmpty()      = " + blank.isEmpty());    // false! has spaces
        System.out.println("blank.isBlank()      = " + blank.isBlank());    // true (Java 11+)
        System.out.println("blank.trim().isEmpty() = " + blank.trim().isEmpty());

        // ─── Accessing Characters ─────────────────────────────────────────────
        System.out.println("\n=== Accessing Characters ===");
        System.out.println("charAt(0)            = " + s1.charAt(0));   // 'H'
        System.out.println("charAt(7)            = " + s1.charAt(7));   // 'W'
        System.out.println("indexOf('o')         = " + s1.indexOf('o'));      // first 'o'
        System.out.println("lastIndexOf('o')     = " + s1.lastIndexOf('o')); // last 'o'
        System.out.println("indexOf(\"World\")   = " + s1.indexOf("World"));
        System.out.println("contains(\"World\")  = " + s1.contains("World"));

        // ─── Substrings ───────────────────────────────────────────────────────
        System.out.println("\n=== Substrings ===");
        String str = "Java Programming";
        System.out.println("substring(5)         = " + str.substring(5));       // "Programming"
        System.out.println("substring(0, 4)      = " + str.substring(0, 4));    // "Java"
        System.out.println("substring(5, 16)     = " + str.substring(5, 16));   // "Programming"

        // ─── Case Conversion ──────────────────────────────────────────────────
        System.out.println("\n=== Case Conversion ===");
        System.out.println("toUpperCase()        = " + s1.toUpperCase());
        System.out.println("toLowerCase()        = " + s1.toLowerCase());

        // ─── Trimming & Stripping ─────────────────────────────────────────────
        System.out.println("\n=== Trimming ===");
        String padded = "   Hello, Java!   ";
        System.out.println("Original     : '" + padded + "'");
        System.out.println("trim()       : '" + padded.trim() + "'");    // removes ASCII whitespace
        System.out.println("strip()      : '" + padded.strip() + "'");   // Unicode-aware (Java 11+)
        System.out.println("stripLeading : '" + padded.stripLeading() + "'");
        System.out.println("stripTrailing: '" + padded.stripTrailing() + "'");

        // ─── Comparison ───────────────────────────────────────────────────────
        System.out.println("\n=== Comparison ===");
        String a = "hello";
        String b = "HELLO";
        System.out.println("a.equals(b)             = " + a.equals(b));
        System.out.println("a.equalsIgnoreCase(b)   = " + a.equalsIgnoreCase(b));
        System.out.println("a.compareTo(b)          = " + a.compareTo(b));      // negative: a < b
        System.out.println("a.compareToIgnoreCase(b)= " + a.compareToIgnoreCase(b)); // 0: equal

        // ─── Starts / Ends With ───────────────────────────────────────────────
        System.out.println("\n=== startsWith / endsWith ===");
        System.out.println("s1.startsWith(\"Hello\") = " + s1.startsWith("Hello"));
        System.out.println("s1.endsWith(\"!\")       = " + s1.endsWith("!"));

        // ─── Replace ──────────────────────────────────────────────────────────
        System.out.println("\n=== Replace ===");
        System.out.println("replace('l','L')         = " + s1.replace('l', 'L'));
        System.out.println("replace(\"World\",\"Java\") = " + s1.replace("World", "Java"));
        System.out.println("replaceAll (regex)       = " + "a1b2c3".replaceAll("[0-9]", "#"));
        System.out.println("replaceFirst (regex)     = " + "a1b2c3".replaceFirst("[0-9]", "#"));

        // ─── Split & Join ─────────────────────────────────────────────────────
        System.out.println("\n=== Split & Join ===");
        String csv = "apple,banana,cherry,date";
        String[] parts = csv.split(",");
        System.out.print("split(\",\"): ");
        for (String part : parts) System.out.print("[" + part + "] ");
        System.out.println();

        String joined = String.join(" | ", parts);
        System.out.println("join(\" | \", parts): " + joined);

        String joined2 = String.join(", ", "red", "green", "blue");
        System.out.println("join with varargs: " + joined2);

        // ─── String.valueOf & Conversion ──────────────────────────────────────
        System.out.println("\n=== Conversion ===");
        int    num   = 42;
        double dbl   = 3.14;
        boolean flag = true;
        System.out.println("String.valueOf(42)     = " + String.valueOf(num));
        System.out.println("String.valueOf(3.14)   = " + String.valueOf(dbl));
        System.out.println("String.valueOf(true)   = " + String.valueOf(flag));
        System.out.println("Integer.parseInt(\"99\") = " + Integer.parseInt("99"));
        System.out.println("Double.parseDouble(\"3.14\") = " + Double.parseDouble("3.14"));

        // ─── StringBuilder (mutable) ──────────────────────────────────────────
        System.out.println("\n=== StringBuilder ===");
        // Strings are immutable: each concatenation creates a new object.
        // StringBuilder is mutable and far more efficient for repeated modifications.
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(", ");
        sb.append("World");
        sb.append("!");
        System.out.println("StringBuilder result: " + sb.toString());

        sb.insert(7, "Java ");
        System.out.println("After insert(7, \"Java \"): " + sb);

        sb.delete(7, 12);
        System.out.println("After delete(7, 12): " + sb);

        sb.reverse();
        System.out.println("After reverse(): " + sb);

        System.out.println("sb.length() = " + sb.length());

        // ─── Strings are Immutable ────────────────────────────────────────────
        System.out.println("\n=== Immutability ===");
        String original = "immutable";
        String modified = original.toUpperCase();    // new object
        System.out.println("original: " + original); // still "immutable"
        System.out.println("modified: " + modified); // "IMMUTABLE"
    }
}
