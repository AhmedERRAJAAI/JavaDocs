# Data Types in Java

Java is a **statically-typed** language: every variable must be declared with a type before use, and that type cannot change at runtime. Java splits all types into two families: **primitives** and **reference types**.

---

## 1. Primitive Data Types

Primitives are the building blocks of Java. They are stored **directly on the stack** (fast access, fixed size) and are not objects.

| Type      | Size    | Default | Range / Notes                              |
|-----------|---------|---------|---------------------------------------------|
| `byte`    | 8-bit   | `0`     | −128 to 127                                |
| `short`   | 16-bit  | `0`     | −32,768 to 32,767                          |
| `int`     | 32-bit  | `0`     | −2,147,483,648 to 2,147,483,647            |
| `long`    | 64-bit  | `0L`    | ±9.2 × 10¹⁸ — suffix `L` required         |
| `float`   | 32-bit  | `0.0f`  | ~6–7 decimal digits of precision           |
| `double`  | 64-bit  | `0.0`   | ~15–16 decimal digits — preferred default  |
| `char`    | 16-bit  | `'\u0000'` | Single Unicode character (0 to 65,535)  |
| `boolean` | JVM-dependent | `false` | Only `true` or `false`              |

### Key rules
- Use **`int`** for integers by default; switch to `long` when values exceed ~2 billion.  
- Use **`double`** for floating-point by default; `float` saves memory but loses precision.  
- Append **`L`** to long literals (`8_000_000_000L`) and **`f`** to float literals (`3.14f`).  
- Underscores in numeric literals (`1_000_000`) are purely cosmetic and improve readability.

---

## 2. Type Casting

Because Java won't silently lose data, you must tell the compiler when you intend a narrowing conversion.

### Widening (implicit)
Smaller type → larger type. The compiler does this automatically because no data is lost.

```
byte → short → int → long → float → double
char → int
```

```java
int i = 42;
double d = i;   // widening: safe, no cast needed
```

### Narrowing (explicit)
Larger type → smaller type. You must cast explicitly with `(type)`. Data may be truncated or overflow.

```java
double gpa = 3.99;
int truncated = (int) gpa;   // → 3 (decimal dropped, NOT rounded)

int big = 300;
byte b = (byte) big;         // → 44 (overflow — 300 % 256)
```

### char ↔ int
A `char` is really an unsigned 16-bit integer, so it can be cast to/from `int` freely:

```java
char letter = 'A';
int code = letter;        // → 65
char back = (char) 66;    // → 'B'
```

---

## 3. Reference Data Types

Reference types store a **pointer** to an object on the heap, not the object itself. The default value for any uninitialized reference is `null`.

### String
`String` is the most common reference type. It is **immutable** — every "modification" creates a new object.

```java
String greeting = "Hello, World!";
String upper = greeting.toUpperCase();  // new object returned
```

String literals are **interned**: the JVM keeps a pool of string literals and reuses them, so two variables with the same literal content often point to the same object.

```java
String a = "hello";
String b = "hello";
System.out.println(a == b);       // true  (same pool object)
System.out.println(a.equals(b));  // true  (same content)

String c = new String("hello");
System.out.println(a == c);       // false (new heap object)
System.out.println(a.equals(c));  // true
```

> **Rule of thumb:** Always compare strings with `.equals()`, never with `==`.

### Arrays
Arrays are fixed-size, zero-indexed containers. They can hold primitives or reference types.

```java
int[]    scores  = {95, 88, 72};
String[] colors  = new String[3];   // initialized to null
colors[0] = "Red";
System.out.println(scores.length);  // → 3
```

---

## 4. Wrapper Classes & Autoboxing

Every primitive has a corresponding class in `java.lang` that wraps it as an object, enabling use in collections and providing utility methods.

| Primitive | Wrapper   |
|-----------|-----------|
| `int`     | `Integer` |
| `double`  | `Double`  |
| `boolean` | `Boolean` |
| `char`    | `Character` |
| `long`    | `Long`    |
| …         | …         |

**Autoboxing** — Java automatically converts between primitive and wrapper:

```java
Integer boxed   = 42;       // autoboxing:  int → Integer
int     unboxed = boxed;    // unboxing:    Integer → int
```

Useful wrapper methods:

```java
Integer.parseInt("123")        // → 123
Integer.toBinaryString(10)     // → "1010"
Double.isNaN(0.0 / 0.0)       // → true
Character.isLetter('A')        // → true
```

---

## 5. `var` — Local Variable Type Inference (Java 10+)

Inside a method, you can let the compiler infer the type:

```java
var name    = "Alice";   // inferred as String
var count   = 0;         // inferred as int
var prices  = new double[]{1.5, 2.0};
```

`var` is just syntactic sugar — the type is still fixed at compile time.

---

## Summary

| Category       | Lives on   | Default value | Example                  |
|----------------|------------|---------------|--------------------------|
| Primitive       | Stack      | 0 / false     | `int x = 5;`             |
| Reference       | Heap       | `null`        | `String s = "hi";`       |
| Wrapper         | Heap       | `null`        | `Integer n = 42;`        |
