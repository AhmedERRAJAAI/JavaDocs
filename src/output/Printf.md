# Formatted Output in Java — `printf` & `String.format`

Java provides powerful tools for formatting output. The most important are `System.out.printf()` and `String.format()`, both of which use the same **format string** syntax.

---

## 1. `System.out.printf`

Prints a formatted string directly to the console. Does **not** add a newline automatically.

```java
System.out.printf(formatString, arg1, arg2, ...);
```

```java
System.out.printf("Name: %s, Age: %d, GPA: %.2f%n", "Alice", 30, 3.75);
// Output: Name: Alice, Age: 30, GPA: 3.75
```

---

## 2. Format Specifier Syntax

```
%[flags][width][.precision]conversion
```

| Component    | Description                                         |
|--------------|-----------------------------------------------------|
| `%`          | Marks the start of a format specifier              |
| `flags`      | Optional modifiers (alignment, sign, padding, etc.) |
| `width`      | Minimum number of characters to output             |
| `.precision` | Decimal places (for floats) or max chars (for strings) |
| `conversion` | The type of the argument (`s`, `d`, `f`, etc.)     |

---

## 3. Conversion Characters

| Specifier | Type               | Example                    | Output         |
|-----------|--------------------|----------------------------|----------------|
| `%s`      | String             | `%s`, "hello"              | `hello`        |
| `%S`      | String (uppercase) | `%S`, "hello"              | `HELLO`        |
| `%d`      | int / long         | `%d`, 42                   | `42`           |
| `%f`      | float / double     | `%.2f`, 3.14159            | `3.14`         |
| `%e`      | Scientific notation| `%e`, 12345.678            | `1.234568e+04` |
| `%g`      | Shorter of `%f`/`%e` | `%g`, 0.00001            | `1.00000e-05`  |
| `%c`      | char               | `%c`, 'A'                  | `A`            |
| `%b`      | boolean            | `%b`, true                 | `true`         |
| `%x`      | Hexadecimal (lower)| `%x`, 255                  | `ff`           |
| `%X`      | Hexadecimal (upper)| `%X`, 255                  | `FF`           |
| `%o`      | Octal              | `%o`, 8                    | `10`           |
| `%%`      | Literal `%`        | `100%%`                    | `100%`         |
| `%n`      | Platform newline   | `"line1%nline2"`           | line break     |

---

## 4. Flags

| Flag | Meaning                                      | Example       | Output   |
|------|----------------------------------------------|---------------|----------|
| `-`  | Left-align within field width                | `%-10s`, "hi" | `hi        ` |
| `+`  | Always show sign                             | `%+d`, 42     | `+42`    |
| `0`  | Pad with zeros instead of spaces             | `%06d`, 42    | `000042` |
| `,`  | Thousands separator                          | `%,d`, 1000000| `1,000,000` |
| ` `  | Space before positive number                 | `% d`, 42     | ` 42`    |
| `(`  | Enclose negative in parentheses              | `%(d`, -42    | `(42)`   |

---

## 5. Width and Precision

**Width** sets the minimum field size. Output is right-aligned by default; use `-` to left-align.

```java
System.out.printf("'%8d'%n",  42);   // '      42'  (right-aligned in 8)
System.out.printf("'%-8d'%n", 42);   // '42      '  (left-aligned in 8)
System.out.printf("'%08d'%n", 42);   // '00000042'  (zero-padded)
```

**Precision** for floating-point controls decimal places:

```java
System.out.printf("%.0f%n", Math.PI);  // 3
System.out.printf("%.2f%n", Math.PI);  // 3.14
System.out.printf("%.5f%n", Math.PI);  // 3.14159
```

**Precision** for strings limits the maximum characters printed:

```java
System.out.printf("%.3s%n", "Hello");  // Hel
```

---

## 6. `String.format`

Works exactly like `printf` but **returns the formatted string** instead of printing it. Use when you need to store, log, or further process the result.

```java
String msg = String.format("Hello, %s! You are %d years old.", "Bob", 25);
System.out.println(msg);

// Build a formatted table row
String row = String.format("%-12s %6d %8.2f", "Apple", 150, 0.99);
```

---

## 7. `%n` vs `\n`

| Sequence | Behavior                                   |
|----------|--------------------------------------------|
| `\n`     | Hardcoded Unix newline (`LF`, `\u000A`)    |
| `%n`     | Platform-specific newline (recommended)    |

On Windows, `%n` produces `\r\n`; on Unix/Mac it produces `\n`. Use `%n` in `printf`/`format` for portable code.

---

## 8. Formatted Tables

A common use case — aligning columns of data:

```java
System.out.printf("%-12s %6s %8s%n", "Product", "Units", "Price");
System.out.printf("%-12s %6d %8.2f%n", "Apple",  150, 0.99);
System.out.printf("%-12s %6d %8.2f%n", "Banana",  75, 0.49);
```

Output:
```
Product       Units    Price
Apple           150     0.99
Banana           75     0.49
```

---

## 9. `System.out.println` vs `printf`

| Method       | Newline | Formatting |
|--------------|---------|------------|
| `println`    | Auto    | None (uses `toString()`) |
| `print`      | None    | None |
| `printf`     | Manual (`%n`) | Full format specifiers |
| `format`     | Manual  | Same as `printf` (alias) |

`System.out.format(...)` is an exact alias for `System.out.printf(...)`.
