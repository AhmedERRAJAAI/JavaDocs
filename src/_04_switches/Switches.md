# Switch Statements & Expressions in Java

The `switch` construct provides a clean way to select one branch out of many based on the value of a single variable. Java has evolved `switch` significantly over the years — from the classic fall-through statement to modern switch expressions.

---

## 1. Classic `switch` Statement

Tests a variable against a series of constant `case` values. Execution **falls through** to the next case unless stopped by `break`.

```java
switch (variable) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    default:
        // code for any unmatched case
}
```

### Supported types:
- `byte`, `short`, `int`, `char`
- `String` (since Java 7)
- `enum` types
- Wrapper types: `Byte`, `Short`, `Integer`, `Character`

> **Not supported:** `long`, `float`, `double`, `boolean`

---

## 2. Fall-Through Behavior

Without a `break`, execution **falls through** into the next case automatically. This can be a bug or a feature, depending on intent.

**Accidental fall-through (bug):**
```java
switch (day) {
    case 1:
        System.out.println("Monday");
        // ← missing break! Will also print "Tuesday"
    case 2:
        System.out.println("Tuesday");
        break;
}
```

**Intentional fall-through (feature):**
```java
switch (month) {
    case 1: case 3: case 5: case 7:
    case 8: case 10: case 12:
        daysInMonth = 31;
        break;
    case 4: case 6: case 9: case 11:
        daysInMonth = 30;
        break;
}
```

---

## 3. Arrow `switch` Statement (Java 14+)

The arrow `->` syntax eliminates fall-through entirely. Each arm is independent.

```java
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    case 6, 7 -> System.out.println("Weekend");   // multiple labels with comma
    default -> System.out.println("Weekday");
}
```

Benefits over classic switch:
- No `break` needed — no accidental fall-through.
- Multiple case labels per arm with commas.
- Cleaner, more readable syntax.

---

## 4. Switch Expression (Java 14+)

A `switch` that **yields a value** and can be used in an assignment or as part of an expression.

```java
String grade = switch (score / 10) {
    case 10, 9 -> "A";
    case 8     -> "B";
    case 7     -> "C";
    case 6     -> "D";
    default    -> "F";
};
```

The switch expression must be **exhaustive**: every possible value must be covered, either by explicit cases or `default`.

### Multi-line arms with `yield`

When an arm needs more than one statement, use a block `{}` and `yield` to return the value:

```java
String result = switch (x) {
    case 1 -> "one";
    case 2 -> {
        String s = compute();
        yield s.toUpperCase();   // yield replaces return inside switch expression
    }
    default -> "other";
};
```

---

## 5. Switch on String (Java 7+)

`switch` works on `String` by calling `.equals()` internally:

```java
String season = "Winter";
switch (season) {
    case "Spring" -> System.out.println("Flowers bloom.");
    case "Summer" -> System.out.println("Hot weather.");
    case "Autumn", "Fall" -> System.out.println("Leaves fall.");
    case "Winter" -> System.out.println("Cold weather.");
    default -> System.out.println("Unknown.");
}
```

> **Note:** If `season` is `null`, a `NullPointerException` is thrown. Always null-check before switching on strings.

---

## 6. Switch on Enum

Switch over enum values provides **compile-time safety**: the compiler warns if a case is missing.

```java
enum Direction { NORTH, SOUTH, EAST, WEST }

Direction d = Direction.NORTH;
String move = switch (d) {
    case NORTH -> "Up";
    case SOUTH -> "Down";
    case EAST  -> "Right";
    case WEST  -> "Left";
    // No default needed: all enum values are covered
};
```

---

## 7. `switch` vs `if-else-if`

| Aspect               | `switch`                                     | `if-else-if`                         |
|----------------------|----------------------------------------------|--------------------------------------|
| Condition type       | Equality (`==`) only                         | Any boolean expression               |
| Range checks         | Not possible (`case x > 5` is invalid)       | Possible (`if (x > 5)`)              |
| Multiple values/arm  | Yes (fall-through or comma in arrow syntax)  | Requires `||`                        |
| Readability          | Cleaner for many discrete values             | Better for ranges and complex logic  |
| Performance          | JVM can optimize to jump table               | Linear evaluation                    |

---

## 8. Evolution of `switch`

| Java Version | Feature Added                                        |
|-------------|------------------------------------------------------|
| Java 1      | Classic `switch` with `break`/fall-through           |
| Java 7      | `switch` on `String`                                 |
| Java 14     | Arrow `->` syntax, switch expressions (standard)     |
| Java 17     | Pattern matching in switch (preview → standard 21)   |
| Java 21     | Pattern matching & guarded patterns in switch        |

---

## Summary

| Syntax          | Fall-through | Returns value | Java version |
|-----------------|:------------:|:-------------:|:------------:|
| Classic `switch`| Yes (with `break`)| No       | All          |
| Arrow `switch`  | No           | No            | 14+          |
| Switch expression| No          | Yes (via `->` or `yield`) | 14+ |
