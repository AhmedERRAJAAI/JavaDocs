public class StringMethods {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "hello, world!";
        String str3 = "   Hello, World!   ";

        // length() method
        System.out.println("Length of str1: " + str1.length());

        // charAt() method
        System.out.println("Character at index 7 in str1: " + str1.charAt(7));

        // substring() method
        System.out.println("Substring of str1 from index 0 to 5: " + str1.substring(0, 5));

        // toUpperCase() and toLowerCase() methods
        System.out.println("str1 in uppercase: " + str1.toUpperCase());
        System.out.println("str1 in lowercase: " + str1.toLowerCase());

        // trim() method
        System.out.println("str3 before trim: '" + str3 + "'");
        System.out.println("str3 after trim: '" + str3.trim() + "'");

        // equals() and equalsIgnoreCase() methods
        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase str2: " + str1.equalsIgnoreCase(str2));

        // contains() method
        System.out.println("str1 contains 'World': " + str1.contains("World"));

        // replace() method
        System.out.println("str1 after replacing 'World' with 'Java': " + str1.replace("World", "Java"));

        // SUBSTRING METHOD
        String str4 = "Java Programming";
        System.out.println("Substring of str4 from index 5 to 16: " + str4.substring(5, 16));
        System.out.println("Substring of str4 from index 5 to the end: " + str4.substring(5));
    }
}
