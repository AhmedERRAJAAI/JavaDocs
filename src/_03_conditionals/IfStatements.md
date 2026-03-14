# If Statements & Conditionals in Java

Conditional statements allow your program to make decisions at runtime and execute different code paths depending on whether conditions are true or false.

---

## 1. Basic `if` Statement

Executes a block **only when** the condition is `true`. If the condition is `false`, the block is skipped entirely.

```java
int temperature = 35;
if (temperature > 30) {
    System.out.println("It's hot outside.");
}
```

> The curly braces `{}` are optional when there is only one statement, but **always use them** — omitting them is a common source of bugs.

---

## 2. `if-else` Statement

Provides a fallback block that runs when the condition is `false`.

```java
int number = 7;
if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

---

## 3. `if-else-if` Chain (Multi-Branch)

Tests multiple conditions in sequence. The **first** matching branch executes; the rest are skipped.

```java
int score = 82;
if      (score >= 90) System.out.println("A");
else if (score >= 80) System.out.println("B");
else if (score >= 70) System.out.println("C");
else if (score >= 60) System.out.println("D");
else                  System.out.println("F");
```

Once a branch matches, Java exits the entire `if-else-if` chain — subsequent conditions are not evaluated.

---

## 4. Nested `if`

An `if` statement inside another `if`. Use when the second check only makes sense if the first passes.

```java
if (age >= 18) {
    if (hasId) {
        System.out.println("Access granted.");
    } else {
        System.out.println("No ID — access denied.");
    }
}
```

> Avoid deeply nested `if`s — they reduce readability. Consider combining conditions with logical operators or extracting logic into helper methods.

---

## 5. Comparison Operators

| Operator | Meaning                  |
|----------|--------------------------|
| `==`     | Equal to                 |
| `!=`     | Not equal to             |
| `>`      | Greater than             |
| `<`      | Less than                |
| `>=`     | Greater than or equal to |
| `<=`     | Less than or equal to    |

> **Important:** `==` compares **object references** for non-primitives. Use `.equals()` to compare **content** (e.g., Strings).

```java
String a = new String("hello");
String b = new String("hello");
System.out.println(a == b);        // false (different objects in memory)
System.out.println(a.equals(b));   // true  (same characters)
```

---

## 6. Logical Operators

Combine multiple boolean conditions into one.

| Operator | Name | Result                                        |
|----------|------|-----------------------------------------------|
| `&&`     | AND  | `true` only if **both** sides are `true`      |
| `\|\|`   | OR   | `true` if **at least one** side is `true`     |
| `!`      | NOT  | Inverts the boolean value                     |

```java
int x = 15;
if (x > 10 && x < 20) { ... }   // both must be true
if (x < 5  || x > 10) { ... }   // at least one must be true
if (!isRaining)        { ... }   // true when isRaining is false
```

---

## 7. Short-Circuit Evaluation

Java uses **short-circuit** logic for `&&` and `||`:

- **`&&`** — if the **left** side is `false`, the right side is **never evaluated** (result is already `false`).
- **`||`** — if the **left** side is `true`,  the right side is **never evaluated** (result is already `true`).

This is crucial for **safe null checks**:

```java
String name = null;

// Without short-circuit: name.length() would throw NullPointerException
// With short-circuit:    when name == null is true, length() is never called
if (name != null && name.length() > 0) {
    System.out.println("Non-empty name: " + name);
}
```

---

## 8. Ternary Operator `? :`

A concise one-line `if-else` that evaluates to a value. Ideal for simple assignments.

```
condition ? valueIfTrue : valueIfFalse
```

```java
int max = (a > b) ? a : b;
String label = (age >= 18) ? "adult" : "minor";
```

Nested ternary is possible but should be used sparingly:

```java
String grade = (score >= 90) ? "A" : (score >= 70) ? "B" : "C";
```

> Prefer `if-else-if` when there are more than two outcomes — readability matters more than brevity.

---

## 9. Common Pitfalls

### Assignment vs comparison
```java
int n = 5;
if (n = 10) { ... }   // COMPILE ERROR in Java (unlike C/C++)
if (n == 10) { ... }  // Correct comparison
```

### Floating-point equality
```java
double a = 0.1 + 0.2;
if (a == 0.3) { ... }             // May be false due to floating-point imprecision!
if (Math.abs(a - 0.3) < 1e-9) { ... }  // Correct way to compare doubles
```

### `else` always binds to the nearest `if`
```java
if (x > 0)
    if (x > 10)
        System.out.println("big");
else                               // this else belongs to (x > 10), NOT (x > 0)!
    System.out.println("small");
```
Always use braces to make the binding explicit.

---

## Summary

| Construct         | Use when…                                           |
|-------------------|-----------------------------------------------------|
| `if`              | You need to run code conditionally                  |
| `if-else`         | There are exactly two outcomes                      |
| `if-else-if`      | There are three or more mutually exclusive outcomes |
| Nested `if`       | Second condition only makes sense if first is true  |
| Ternary `? :`     | Simple one-liner assignment based on a condition    |
| `&&` / `\|\|`    | Combining multiple boolean conditions               |
