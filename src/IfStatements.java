public class IfStatements {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Prompt the user for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // If statement
        if (number > 0) {
            System.out.println("The number is positive.");
        }

        // If-else statement
        if (number % 2 == 0) {
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");
        }

        // If-else-if statement
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // Nested if statement
        if (number != 0) {
            System.out.println("\nChecking additional properties...");
            if (number > 0) {
                if (number >= 100) {
                    System.out.println("The number is a large positive number (>= 100).");
                } else if (number >= 10) {
                    System.out.println("The number is a medium positive number (10-99).");
                } else {
                    System.out.println("The number is a small positive number (1-9).");
                }
            } else {
                if (number <= -100) {
                    System.out.println("The number is a large negative number (<= -100).");
                } else if (number <= -10) {
                    System.out.println("The number is a medium negative number (-99 to -10).");
                } else {
                    System.out.println("The number is a small negative number (-9 to -1).");
                }
            }
        }

        // Ternary operator
        String result = (number >= 0) ? "non-negative" : "negative";
        System.out.println("The number is " + result + ".");
    }
}
