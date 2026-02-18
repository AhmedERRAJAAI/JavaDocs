public class Printf {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 30;
        double gpa = 3.75;

        // %[flags][width][.precision][specifier-character]
        // Using printf to format the output
        System.out.printf("Hello, %s! You are %d years old and your GPA is %.2f.%n", name, age, gpa);
    }
}
