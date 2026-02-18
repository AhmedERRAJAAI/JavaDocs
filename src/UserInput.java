public class UserInput {
        public static void main(String[] args) {
            // Create a Scanner object to read user input
            java.util.Scanner scanner = new java.util.Scanner(System.in);

            // Prompt the user for their name
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            // Prompt the user for their age
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Prompt the user for their GPA
            System.out.println("Enter your GPA score: ");
            double gpa = scanner.nextDouble();

            // Display the user's input
            System.out.println("Hello, " + name + "! You are " + age + " years old. and your GPA is " + gpa);

            // Close the scanner
            scanner.close();
        }
}
