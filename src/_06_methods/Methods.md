# Methods in Java

A **method** is a named, reusable block of code that performs a specific task. Methods promote code reuse, improve readability, and allow complex problems to be broken into smaller, manageable pieces.

---

## 1. Method Anatomy

```java
accessModifier returnType methodName(parameterList) {
    // body
    return value; // required unless returnType is void
}
```

| Part            | Description                                             |
|-----------------|---------------------------------------------------------|
| Access modifier | Controls visibility (`public`, `private`, etc.)        |
| Return type     | The type of value returned (`int`, `String`, `void`, …) |
| Method name     | camelCase convention (`calculateArea`, `greet`)         |
| Parameters      | Typed inputs (optional)                                 |
| Return statement| Required for non-`void` methods                         |

---

## 2. Access Modifiers

Access modifiers control **who can call a method or access a variable**.

| Modifier    | Same Class | Same Package | Subclass (other pkg) | Any Class |
|-------------|:----------:|:------------:|:--------------------:|:---------:|
| `public`    | ✅          | ✅            | ✅                    | ✅         |
| `protected` | ✅          | ✅            | ✅                    | ❌         |
| *(default)* | ✅          | ✅            | ❌                    | ❌         |
| `private`   | ✅          | ❌            | ❌                    | ❌         |

```java
public  static void publicMethod()    { ... }  // accessible everywhere
protected static void protectedMethod() { ... }  // package + subclasses
static void packageMethod()           { ... }  // same package only (no modifier)
private static void privateHelper()   { ... }  // this class only
```

**Rule of thumb:** Start with `private` and widen visibility only when needed.

---

## 3. `static` Methods

A `static` method belongs to the **class itself**, not to any instance. It can be called without creating an object:

```java
Math.sqrt(16)      // static method — no object needed
```

In a `main`-only program (no objects), all methods are typically `static` so they can be called directly from `main`.

---

## 4. Method Overloading

Multiple methods can share the same name if their **parameter lists differ** (different types, counts, or order). The compiler picks the right one at compile time.

```java
static int    add(int a, int b)          { return a + b; }
static double add(double a, double b)    { return a + b; }
static int    add(int a, int b, int c)   { return a + b + c; }

add(1, 2)         // → int version
add(1.0, 2.0)     // → double version
add(1, 2, 3)      // → three-arg version
```

> **Note:** Return type alone is **not** enough to overload — the parameters must differ.

---

## 5. Varargs (Variable-Length Arguments)

Allows a method to accept **zero or more arguments** of the same type. Declared with `...` and treated as an array inside the method.

```java
static int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) total += n;
    return total;
}

sum()                // → 0
sum(5)               // → 5
sum(1, 2, 3, 4, 5)  // → 15
```

**Rules:**
- Varargs must be the **last** parameter.
- Only one varargs parameter per method.

---

## 6. Recursion

A method that **calls itself**. Every recursive method needs:

1. **Base case** — a condition where the recursion stops.
2. **Recursive case** — breaks the problem into a smaller version of itself.

```java
static long factorial(int n) {
    if (n <= 1) return 1;              // base case
    return n * factorial(n - 1);       // recursive case
}
// factorial(5) = 5 × 4 × 3 × 2 × 1 = 120
```

**Stack trace for `factorial(4)`:**
```
factorial(4)
  → 4 * factorial(3)
       → 3 * factorial(2)
            → 2 * factorial(1)
                 → returns 1
            → returns 2
       → returns 6
  → returns 24
```

> **Caution:** Deep recursion causes `StackOverflowError`. For large inputs, prefer an iterative approach or tail recursion.

---

## 7. Pass by Value

**Java always passes arguments by value** — it copies the value into the parameter.

### Primitives — original is never modified:
```java
static void tryToModify(int x) { x = 999; }

int n = 42;
tryToModify(n);
System.out.println(n);   // still 42
```

### Objects/Arrays — the reference is copied, so the **object can be mutated**:
```java
static void modifyArray(int[] arr) { arr[0] = 999; }

int[] data = {1, 2, 3};
modifyArray(data);
System.out.println(data[0]);   // 999 — object was mutated through the copied reference
```

> Reassigning the parameter itself (e.g., `arr = new int[]{0}`) does **not** affect the caller.

---

## 8. Return Types

| Return type | Meaning                                    |
|-------------|--------------------------------------------|
| `void`      | Method returns nothing                     |
| `int`, `double`, … | Returns a primitive value         |
| `String`, `Object`, … | Returns a reference type        |
| Array / collection | Returns a complex data structure   |

A method can have **multiple `return` statements** (e.g., early returns):

```java
static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    // ...
}
```

---

## 9. Best Practices

- **Single Responsibility** — each method should do exactly one thing.
- **Descriptive names** — `calculateTax()` is better than `calc()`.
- **Keep methods short** — if a method is longer than ~20 lines, consider splitting it.
- **Use `private`** for internal helpers; expose only what callers need.
- **Avoid side effects** — prefer returning values over modifying global state.
