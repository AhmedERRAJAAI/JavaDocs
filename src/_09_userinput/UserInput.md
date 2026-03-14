# User Input in Java — `Scanner`

`java.util.Scanner` is the standard class for reading user input from the console (or any other input stream). It parses tokens from the input, making it easy to read integers, doubles, strings, and more.

---

## 1. Creating a Scanner

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);  // reads from the keyboard
```

`System.in` is the standard input stream. `Scanner` can also wrap a `File`, `String`, or any `InputStream`.

---

## 2. Reading Methods

| Method           | Reads                              | Notes                                       |
|------------------|------------------------------------|---------------------------------------------|
| `nextLine()`     | One entire line (including spaces) | Stops at `\n` — consumes the newline        |
| `next()`         | One token (whitespace-delimited)   | Stops at whitespace — does NOT consume `\n` |
| `nextInt()`      | Next `int` token                   | Throws `InputMismatchException` if not int  |
| `nextDouble()`   | Next `double` token                | Locale-dependent decimal separator          |
| `nextLong()`     | Next `long` token                  |                                             |
| `nextBoolean()`  | Next `boolean` token               | Reads `true`/`false` (case-insensitive)     |
| `nextFloat()`    | Next `float` token                 |                                             |

```java
Scanner sc = new Scanner(System.in);

String name   = sc.nextLine();    // "John Doe"
int age       = sc.nextInt();     // 25
double price  = sc.nextDouble();  // 9.99
boolean flag  = sc.nextBoolean(); // true
```

---

## 3. The `nextLine()` After `nextInt()` Trap

**Problem:** `nextInt()` (and `nextDouble()`, etc.) read the value but leave the trailing newline `\n` in the buffer. The next `nextLine()` call immediately consumes that newline and returns an empty string.

```java
int age = scanner.nextInt();
String name = scanner.nextLine();  // BUG: returns "" because it reads the leftover \n
```

**Fix:** Call `scanner.nextLine()` once after reading a number to flush the newline:

```java
int age = scanner.nextInt();
scanner.nextLine();           // flush the newline
String name = scanner.nextLine();  // now reads correctly
```

---

## 4. Checking Input with `hasNextXxx`

Before calling a `nextXxx` method, you can check if the next token is the expected type:

```java
while (!scanner.hasNextInt()) {
    System.out.println("Please enter an integer:");
    scanner.next();   // discard the invalid token
}
int n = scanner.nextInt();
```

| Method            | Returns `true` when…                     |
|-------------------|------------------------------------------|
| `hasNext()`       | Another token is available               |
| `hasNextLine()`   | Another line is available                |
| `hasNextInt()`    | Next token is a valid `int`              |
| `hasNextDouble()` | Next token is a valid `double`           |

---

## 5. Reading Until Sentinel

A common pattern: keep reading until the user enters a special "stop" value.

```java
System.out.println("Enter numbers (0 to quit):");
int n;
while ((n = scanner.nextInt()) != 0) {
    System.out.println("You entered: " + n);
}
```

---

## 6. Reading Multiple Values Per Line

`Scanner` splits on whitespace by default, so values separated by spaces on the same line can be read with successive calls:

```java
System.out.print("Enter x y: ");  // user types: 3 7
int x = scanner.nextInt();        // 3
int y = scanner.nextInt();        // 7
```

To change the delimiter (e.g., read comma-separated values):

```java
scanner.useDelimiter(",");
```

---

## 7. Closing the Scanner

```java
scanner.close();
```

Releases the underlying input stream. After closing, any further read attempts throw `IllegalStateException`.

> **Note:** Closing a `Scanner` wrapping `System.in` also closes `System.in` — after that, no other part of the program can read from the keyboard. In larger programs, it's often left open until the JVM exits.

---

## 8. Common Exceptions

| Exception                  | Cause                                            |
|----------------------------|--------------------------------------------------|
| `InputMismatchException`   | Token doesn't match the expected type            |
| `NoSuchElementException`   | No more input available (EOF reached)            |
| `IllegalStateException`    | Scanner was closed before reading                |

---

## 9. Practical Tips

- **Always close** the scanner when you're done (or use try-with-resources in Java 7+):
  ```java
  try (Scanner scanner = new Scanner(System.in)) {
      // use scanner
  }
  // scanner is automatically closed here
  ```
- **Validate input** with `hasNextXxx()` to prevent `InputMismatchException` from crashing your program.
- **Prefer `nextLine()` + manual parsing** for complex input, to avoid newline issues:
  ```java
  String line = scanner.nextLine();
  int n = Integer.parseInt(line.trim());
  ```
