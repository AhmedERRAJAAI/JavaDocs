# Strings in Java

`String` is the most frequently used class in Java. Understanding how strings work — especially their immutability and the methods available — is fundamental to everyday Java programming.

---

## 1. What is a String?

A `String` is an **immutable** sequence of Unicode characters, backed by a `char[]` array internally. Once created, the contents of a `String` **can never change**. Any method that appears to "modify" a string actually returns a **new String object**.

```java
String s = "hello";
s.toUpperCase();             // new "HELLO" is created — s is unchanged
System.out.println(s);       // still "hello"

String upper = s.toUpperCase();
System.out.println(upper);   // "HELLO"
```

---

## 2. Creating Strings

```java
String literal = "Hello";                    // preferred — uses string pool
String object  = new String("Hello");        // new heap object — avoid
String fromNum = String.valueOf(42);          // from primitive
String concat  = "Hello" + ", " + "World";   // concatenation (creates new strings)
```

**String Pool:** When you write `"Hello"` as a literal, Java stores it in a shared pool. Two literals with the same content share the same object:

```java
String a = "hello";
String b = "hello";
System.out.println(a == b);       // true (same pool object)
System.out.println(a.equals(b));  // true

String c = new String("hello");
System.out.println(a == c);       // false (different heap object)
System.out.println(a.equals(c));  // true — always use .equals() for content comparison
```

---

## 3. Core String Methods

### Inspection

| Method                    | Description                              | Example                        |
|---------------------------|------------------------------------------|--------------------------------|
| `length()`                | Number of characters                     | `"hello".length()` → `5`       |
| `isEmpty()`               | `true` if length == 0                    | `"".isEmpty()` → `true`        |
| `isBlank()` *(Java 11)*   | `true` if empty or only whitespace       | `"  ".isBlank()` → `true`      |
| `charAt(int i)`           | Character at index `i`                   | `"abc".charAt(1)` → `'b'`      |
| `indexOf(String s)`       | First occurrence index, or -1            | `"hello".indexOf("ll")` → `2`  |
| `lastIndexOf(String s)`   | Last occurrence index, or -1            | `"abcabc".lastIndexOf("a")` → `3` |
| `contains(CharSequence s)`| `true` if s is found                    | `"hello".contains("ell")` → `true` |
| `startsWith(String prefix)`| Prefix check                           | `"hello".startsWith("he")` → `true` |
| `endsWith(String suffix)` | Suffix check                             | `"hello".endsWith("lo")` → `true` |

### Transformation (returns new String)

| Method                                  | Description                            |
|-----------------------------------------|----------------------------------------|
| `toUpperCase()` / `toLowerCase()`       | Change case                            |
| `trim()`                                | Remove ASCII leading/trailing spaces   |
| `strip()` *(Java 11)*                   | Unicode-aware trim                     |
| `stripLeading()` / `stripTrailing()`    | One-sided strip *(Java 11)*            |
| `replace(old, new)`                     | Replace characters or substrings       |
| `replaceAll(regex, replacement)`        | Replace using regular expression       |
| `replaceFirst(regex, replacement)`      | Replace first regex match              |

### Extraction

| Method                          | Description                                              |
|---------------------------------|----------------------------------------------------------|
| `substring(int start)`          | From `start` to end                                      |
| `substring(int start, int end)` | From `start` (inclusive) to `end` (exclusive)           |
| `split(String regex)`           | Split into array by regex delimiter                      |
| `split(String regex, int limit)`| Split with max number of parts                          |
| `chars()`                       | Returns `IntStream` of character codes *(Java 8+)*      |

### Comparison

| Method                              | Description                             |
|-------------------------------------|-----------------------------------------|
| `equals(Object o)`                  | Case-sensitive content equality         |
| `equalsIgnoreCase(String s)`        | Case-insensitive equality               |
| `compareTo(String s)`               | Lexicographic order; 0 = equal          |
| `compareToIgnoreCase(String s)`     | Case-insensitive lexicographic order    |

### Assembly

| Method                                   | Description                                     |
|------------------------------------------|-------------------------------------------------|
| `String.join(delim, ...parts)`           | Join strings with a delimiter                   |
| `String.format(format, ...args)`         | `printf`-style formatting into a String         |
| `concat(String s)`                       | Append (prefer `+` operator)                    |
| `repeat(int n)` *(Java 11)*              | Repeat string n times                           |

---

## 4. `substring` Indexing

Indexes in Java strings are **zero-based** and refer to positions **between characters**:

```
 H  e  l  l  o
 0  1  2  3  4   ← char indices
```

- `substring(1, 4)` → `"ell"` (chars at 1, 2, 3 — index 4 is excluded)
- `substring(2)`    → `"llo"` (from index 2 to end)

---

## 5. `StringBuilder` — Mutable Strings

Because `String` is immutable, repeated concatenation in a loop is inefficient:

```java
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;   // creates 1000 new String objects!
}
```

Use **`StringBuilder`** instead — it maintains an internal buffer and modifies it in place:

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);   // no new objects
}
String result = sb.toString();
```

**Key `StringBuilder` methods:**

| Method                        | Description                                  |
|-------------------------------|----------------------------------------------|
| `append(x)`                   | Add to end; accepts any type                 |
| `insert(int offset, x)`       | Insert at position                           |
| `delete(int start, int end)`  | Remove characters in range                   |
| `replace(int s, int e, str)`  | Replace range with string                    |
| `reverse()`                   | Reverse the contents                         |
| `toString()`                  | Convert to immutable `String`                |
| `length()` / `charAt(i)`      | Same as `String`                             |

**`StringBuffer`** is the thread-safe version of `StringBuilder` (slightly slower).

---

## 6. Common Patterns

### Null-safe check
```java
if (str != null && !str.isEmpty()) { ... }
// or Java 11+:
if (str != null && !str.isBlank()) { ... }
```

### Split and process CSV
```java
String csv = "apple,banana,cherry";
for (String fruit : csv.split(",")) {
    System.out.println(fruit.trim());
}
```

### Build a formatted string
```java
String report = String.format("%-10s scored %d (%.1f%%)", name, score, percentage);
```

### Repeat a character
```java
String line = "-".repeat(40);   // Java 11+
```

---

## 7. Immutability — Why It Matters

| Benefit              | Explanation                                                    |
|----------------------|----------------------------------------------------------------|
| **Thread safety**    | Multiple threads can read the same string without synchronization |
| **Hashability**      | `String` can safely be used as a `HashMap` key                 |
| **Security**         | Passwords/file paths can't be changed after validation         |
| **Caching (pool)**   | JVM can safely reuse identical string literals                 |
