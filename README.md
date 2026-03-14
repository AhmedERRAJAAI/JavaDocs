# Java Initiation

A structured collection of Java fundamentals — one concept per package, each with a commented example file and a companion Markdown reference.

---

## Project Structure

```
src/
├── datatypes/
│   ├── DataTypes.java          — Primitives, reference types, casting, autoboxing
│   └── DataTypes.md
├── operators/
│   ├── ArithmeticOperators.java — Arithmetic, increment/decrement, Math class, overflow
│   └── ArithmeticOperators.md
├── conditionals/
│   ├── IfStatements.java        — if / else-if / nested if, ternary, logical operators
│   └── IfStatements.md
├── switches/
│   ├── Switches.java            — Classic switch, arrow syntax, switch expressions, enum
│   └── Switches.md
├── loops/
│   ├── Loops.java               — for, while, do-while, for-each, break, continue
│   └── Loops.md
├── methods/
│   ├── Methods.java             — Overloading, varargs, recursion, access modifiers
│   └── Methods.md
├── strings/
│   ├── StringMethods.java       — Core String API, StringBuilder, split/join, immutability
│   └── StringMethods.md
├── output/
│   ├── Printf.java              — printf, String.format, format specifiers, tables
│   └── Printf.md
├── userinput/
│   ├── UserInput.java           — Scanner, input validation, common pitfalls
│   └── UserInput.md
├── packages/
│   ├── Packages.java            — Package declarations, imports, static imports, access
│   └── Packages.md
├── collections/
│   ├── Collections.java         — ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, Deque, PriorityQueue
│   └── Collections.md
└── exercices/
    └── TemperatureConverter.java — Temperature unit converter (practice exercise)
```

---

## Concepts Covered

| Package        | Key Topics |
|----------------|-----------|
| `datatypes`    | `byte` → `long`, `float` vs `double`, `char`, `boolean`, widening/narrowing casts, wrapper classes, autoboxing |
| `operators`    | `+` `-` `*` `/` `%`, integer division, pre/post `++`/`--`, compound assignment (`+=` etc.), operator precedence, overflow, `Math` |
| `conditionals` | `if`, `if-else`, `if-else-if`, nested `if`, comparison operators, `&&` `\|\|` `!`, short-circuit evaluation, ternary `? :` |
| `switches`     | Classic `switch` with fall-through, arrow `->` syntax, switch expression, `yield`, switch on `String` and `enum` |
| `loops`        | `for`, `while`, `do-while`, enhanced for-each, `break`, `continue`, labeled `break`, nested loops |
| `methods`      | Defining and calling methods, return types, overloading, varargs, recursion, pass-by-value, access modifiers |
| `strings`      | `length`, `charAt`, `substring`, `indexOf`, `replace`, `split`, `join`, `StringBuilder`, immutability |
| `output`       | `System.out.printf`, `String.format`, format specifiers (`%s` `%d` `%f` `%e` `%x` …), width, precision, flags |
| `userinput`    | `Scanner`, `nextLine` / `nextInt` / `nextDouble`, `hasNextInt`, newline pitfall, sentinel loops |
| `packages`     | `package` declaration, `import`, wildcard vs specific imports, `java.lang`, static imports, sub-packages |
| `collections`  | `ArrayList`, `LinkedList`, `HashSet`, `LinkedHashSet`, `TreeSet`, `HashMap`, `LinkedHashMap`, `TreeMap`, `ArrayDeque`, `PriorityQueue`, `Collections` utilities, immutable factories |

---

## How to Use

Each package is self-contained. Open the `.java` file to run and experiment with the examples, and read the paired `.md` file for a thorough explanation of the concept.

### Run a file from the terminal

```bash
# Compile
javac src/loops/Loops.java

# Run (from the src directory)
cd src
javac loops/Loops.java
java loops.Loops
```

### Run from IntelliJ IDEA

1. Open the project (the root folder containing `initiation.iml`).
2. Mark `src/` as the **Sources Root** if not already set.
3. Open any `.java` file and click the green **Run** button next to `main`.

---

## Prerequisites

- **Java 17+** recommended (switch expressions and `isBlank` used in examples)
- Any IDE (IntelliJ IDEA, VS Code with Extension Pack for Java, Eclipse) or just `javac`/`java` from the terminal

---

## Learning Path

Follow the packages in this order for a smooth progression:

1. `datatypes` — understand what types are available
2. `operators` — learn to compute with those types
3. `conditionals` — make decisions
4. `switches` — handle multiple discrete cases
5. `loops` — repeat operations
6. `methods` — organise code into reusable units
7. `strings` — work with text
8. `output` — format and display results
9. `userinput` — read data from the user
10. `packages` — understand how Java organises code at scale
11. `collections` — store, retrieve and manipulate groups of objects
12. `exercices` — apply everything in a real exercise
