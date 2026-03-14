# Arithmetic Operators in Java

Java provides a rich set of operators for performing mathematical calculations. Understanding operator behavior — especially around integer division, overflow, and precedence — is essential for writing correct programs.

---

## 1. Basic Arithmetic Operators

| Operator | Name           | Example    | Result |
|----------|----------------|------------|--------|
| `+`      | Addition       | `10 + 3`   | `13`   |
| `-`      | Subtraction    | `10 - 3`   | `7`    |
| `*`      | Multiplication | `10 * 3`   | `30`   |
| `/`      | Division       | `10 / 3`   | `3`    |
| `%`      | Modulus        | `10 % 3`   | `1`    |

---

## 2. Integer vs Floating-Point Division

When **both operands are integers**, Java performs **integer division** — the result is truncated (not rounded):

```java
System.out.println(10 / 3);      // → 3   (NOT 3.33)
System.out.println(10.0 / 3);    // → 3.3333333333333335
```

To get a floating-point result from two integer variables, cast one of them:

```java
int a = 10, b = 3;
double result = (double) a / b;   // → 3.3333…
```

---

## 3. Modulus Operator `%`

The modulus operator returns the **remainder** after integer division.

```java
10 % 3   // → 1   (10 = 3×3 + 1)
15 % 5   // → 0   (15 is exactly divisible by 5)
```

Common use cases:
- **Check even/odd:** `n % 2 == 0` → even
- **Cycle through values:** `index % arrayLength` → keeps index in bounds
- **Extract digits:** `1234 % 10` → `4` (last digit)
- **Convert seconds:** `total % 60` → remaining seconds after full minutes

---

## 4. Increment & Decrement

| Operator | Type           | Behavior                              |
|----------|----------------|---------------------------------------|
| `++x`    | Pre-increment  | Increment first, then return new value |
| `x++`    | Post-increment | Return current value, then increment  |
| `--x`    | Pre-decrement  | Decrement first, then return new value |
| `x--`    | Post-decrement | Return current value, then decrement  |

```java
int x = 5;
System.out.println(++x);  // prints 6 (x is now 6)
System.out.println(x++);  // prints 6 (x becomes 7)
System.out.println(x);    // prints 7
```

> **Tip:** Prefer `++i` over `i++` inside loops when the return value isn't used — clearer intent.

---

## 5. Compound Assignment Operators

These combine an arithmetic operation with assignment, making code shorter and easier to read.

| Operator | Equivalent to |
|----------|---------------|
| `n += 5` | `n = n + 5`   |
| `n -= 3` | `n = n - 3`   |
| `n *= 2` | `n = n * 2`   |
| `n /= 4` | `n = n / 4`   |
| `n %= 3` | `n = n % 3`   |

---

## 6. Operator Precedence

Java evaluates expressions according to a precedence table (higher = evaluated first):

| Priority | Operators                        |
|----------|----------------------------------|
| 1 (high) | `++` `--` (postfix), unary `+` `-` |
| 2        | `*`  `/`  `%`                    |
| 3        | `+`  `-`                         |
| 4 (low)  | `=` `+=` `-=` …                  |

Operators at the same level are evaluated **left to right**.

```java
2 + 3 * 4       // → 14  (* first)
(2 + 3) * 4     // → 20  (parentheses override precedence)
10 - 2 + 3      // → 11  (left to right)
```

> **Rule:** When in doubt, use parentheses. They cost nothing and prevent bugs.

---

## 7. Integer Overflow & Underflow

Java integers wrap around silently when they exceed their range — there is **no exception**:

```java
int max = Integer.MAX_VALUE;  // 2,147,483,647
System.out.println(max + 1);  // → -2,147,483,648  (wraps to MIN_VALUE!)
```

**Prevention strategies:**
- Use `long` for potentially large values.
- Use `Math.addExact(a, b)` to throw `ArithmeticException` on overflow (Java 8+).
- For arbitrarily large numbers, use `java.math.BigInteger`.

---

## 8. The `Math` Class

`java.lang.Math` provides static methods for common mathematical operations:

```java
Math.abs(-7)        // → 7      (absolute value)
Math.pow(2, 10)     // → 1024.0 (2 to the power of 10)
Math.sqrt(144)      // → 12.0   (square root)
Math.max(18, 25)    // → 25     (larger of two values)
Math.min(18, 25)    // → 18     (smaller of two values)
Math.round(3.7)     // → 4      (rounds to nearest integer)
Math.floor(3.9)     // → 3.0    (rounds down)
Math.ceil(3.1)      // → 4.0    (rounds up)
Math.random()       // → [0.0, 1.0)  (random double)
```

Random integer in range `[min, max]`:

```java
int rand = (int)(Math.random() * (max - min + 1)) + min;
```

---

## Summary

| Concept              | Key Point                                              |
|----------------------|--------------------------------------------------------|
| Integer division     | Truncates: `7/2 → 3`                                  |
| Modulus              | Remainder: `7%2 → 1`                                  |
| Pre vs post `++`     | Pre returns new value; post returns old                |
| Compound assignment  | `n += 5` is shorthand for `n = n + 5`                 |
| Precedence           | `*` `/` `%` before `+` `-`; parentheses override      |
| Overflow             | Wraps silently — use `long` or `Math.addExact()`       |
