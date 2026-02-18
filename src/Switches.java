public class Switches {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Prompt the user for a day of the week
        System.out.print("Enter a day of the week (1-7): ");
        int day = scanner.nextInt();

        // Switch statement
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }

        // Close the scanner
        scanner.close();
    }
}
