package _10_packages;

// Importing a specific class from the java.util package
import java.util.ArrayList;
// Importing all classes from java.util (wildcard import — fine for demos, avoid in large projects)
import java.util.Scanner;

/**
 * This class demonstrates how Java packages work:
 *  - Declaring a package
 *  - Importing classes from other packages
 *  - Package-private (default) vs public access
 */
public class Packages {

    // ─── Package-private helper (default access = no modifier) ───────────────
    // This class is only accessible within the 'packages' package.
    static String packagePrivateMessage() {
        return "I am accessible only inside the 'packages' package.";
    }

    // ─── Public method (accessible from anywhere) ─────────────────────────────
    public static String publicMessage() {
        return "I am accessible from any package.";
    }

    public static void main(String[] args) {

        // ─── Using a class from java.util ────────────────────────────────────
        System.out.println("=== Import Demo ===");

        // ArrayList is in java.util — imported at the top of this file
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Packages");
        list.add("Are Useful");
        System.out.println("ArrayList from java.util: " + list);

        // ─── Fully Qualified Name (no import needed) ──────────────────────────
        System.out.println("\n=== Fully Qualified Name ===");
        // Instead of importing, you can use the full class path inline
        java.util.Date today = new java.util.Date();
        System.out.println("Today (fully qualified): " + today);

        // ─── java.lang is imported automatically ──────────────────────────────
        System.out.println("\n=== java.lang (auto-imported) ===");
        // String, Math, System, Integer etc. are in java.lang — no import needed
        System.out.println("Math.PI      = " + Math.PI);
        System.out.println("Integer.MAX  = " + Integer.MAX_VALUE);
        System.out.println("System class = " + System.class.getName());

        // ─── Accessing methods in this package ───────────────────────────────
        System.out.println("\n=== Package-Private vs Public ===");
        System.out.println(packagePrivateMessage());
        System.out.println(publicMessage());

        // ─── Package Naming Convention ────────────────────────────────────────
        System.out.println("\n=== Package Naming Convention ===");
        System.out.println("Packages use reverse-domain convention:");
        System.out.println("  com.google.gson   (Google Gson library)");
        System.out.println("  org.apache.commons (Apache Commons)");
        System.out.println("  java.util          (Java standard library)");
        System.out.println("This class is in: " + Packages.class.getPackageName());

        // ─── Nested/Sub-packages ─────────────────────────────────────────────
        System.out.println("\n=== Sub-packages ===");
        System.out.println("java.util.concurrent is a sub-package of java.util");
        System.out.println("But importing java.util.* does NOT import java.util.concurrent.*");
        System.out.println("Sub-packages are independent — they must be imported separately.");

        // ─── Static Import Demo ───────────────────────────────────────────────
        System.out.println("\n=== Static Import ===");
        // Without static import you write: Math.sqrt(16)
        // With:  import static java.lang.Math.sqrt;
        //        sqrt(16)  ← no class prefix needed
        // For this demo we call it the normal way to make the concept clear:
        double root = Math.sqrt(16);
        System.out.println("Math.sqrt(16) = " + root);
        System.out.println("(With 'import static java.lang.Math.sqrt;' you could write just sqrt(16))");
    }
}
