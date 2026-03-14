# Java Initiation

A structured collection of Java fundamentals — one concept per package, each with a commented example file and a companion Markdown reference.

---

## Project Structure

```
src/
├── _01_datatypes/
│   ├── DataTypes.java          — Primitives, reference types, casting, autoboxing
│   └── DataTypes.md
├── _02_operators/
│   ├── ArithmeticOperators.java — Arithmetic, increment/decrement, Math class, overflow
│   └── ArithmeticOperators.md
├── _03_conditionals/
│   ├── IfStatements.java        — if / else-if / nested if, ternary, logical operators
│   └── IfStatements.md
├── _04_switches/
│   ├── Switches.java            — Classic switch, arrow syntax, switch expressions, enum
│   └── Switches.md
├── _05_loops/
│   ├── Loops.java               — for, while, do-while, for-each, break, continue
│   └── Loops.md
├── _06_methods/
│   ├── Methods.java             — Overloading, varargs, recursion, access modifiers
│   └── Methods.md
├── _07_strings/
│   ├── StringMethods.java       — Core String API, StringBuilder, split/join, immutability
│   └── StringMethods.md
├── _08_output/
│   ├── Printf.java              — printf, String.format, format specifiers, tables
│   └── Printf.md
├── _09_userinput/
│   ├── UserInput.java           — Scanner, input validation, common pitfalls
│   └── UserInput.md
├── _10_packages/
│   ├── Packages.java            — Package declarations, imports, static imports, access
│   └── Packages.md
├── _11_collections/
│   ├── Collections.java         — ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, Deque, PriorityQueue
│   └── Collections.md
├── _13_intro_oop/
│   ├── Classes.java             — Classes, instantiation, instance vs static fields/methods, scope, encapsulation
│   └── Classes.md
└── _12_exercices/
    └── TemperatureConverter.java — Temperature unit converter (practice exercise)
```

---

## Concepts Covered

| Package              | Key Topics |
|----------------------|-----------|
| `_01_datatypes`      | `byte` → `long`, `float` vs `double`, `char`, `boolean`, widening/narrowing casts, wrapper classes, autoboxing |
| `_02_operators`      | `+` `-` `*` `/` `%`, integer division, pre/post `++`/`--`, compound assignment (`+=` etc.), operator precedence, overflow, `Math` |
| `_03_conditionals`   | `if`, `if-else`, `if-else-if`, nested `if`, comparison operators, `&&` `\|\|` `!`, short-circuit evaluation, ternary `? :` |
| `_04_switches`       | Classic `switch` with fall-through, arrow `->` syntax, switch expression, `yield`, switch on `String` and `enum` |
| `_05_loops`          | `for`, `while`, `do-while`, enhanced for-each, `break`, `continue`, labeled `break`, nested loops |
| `_06_methods`        | Defining and calling methods, return types, overloading, varargs, recursion, pass-by-value, access modifiers |
| `_07_strings`        | `length`, `charAt`, `substring`, `indexOf`, `replace`, `split`, `join`, `StringBuilder`, immutability |
| `_08_output`         | `System.out.printf`, `String.format`, format specifiers (`%s` `%d` `%f` `%e` `%x` …), width, precision, flags |
| `_09_userinput`      | `Scanner`, `nextLine` / `nextInt` / `nextDouble`, `hasNextInt`, newline pitfall, sentinel loops |
| `_10_packages`       | `package` declaration, `import`, wildcard vs specific imports, `java.lang`, static imports, sub-packages |
| `_11_collections`    | `ArrayList`, `LinkedList`, `HashSet`, `LinkedHashSet`, `TreeSet`, `HashMap`, `LinkedHashMap`, `TreeMap`, `ArrayDeque`, `PriorityQueue`, `Collections` utilities, immutable factories |
| `_13_intro_oop`      | Classes, objects, instantiation, `new`, instance vs static fields & methods, `this`, constructors, scope (local / instance / static / block), encapsulation, `toString` |
| `_12_exercices`      | Practice exercise — Temperature unit converter applying multiple concepts |

---

## How to Use

Each package is self-contained. Open the `.java` file to run and experiment with the examples, and read the paired `.md` file for a thorough explanation of the concept.

### Run a file from the terminal

```bash
# From the src directory
cd src
javac _05_loops/Loops.java
java _05_loops.Loops
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

The packages are numbered in the recommended order — just follow them top to bottom:

1. `_01_datatypes` — understand what types are available
2. `_02_operators` — learn to compute with those types
3. `_03_conditionals` — make decisions
4. `_04_switches` — handle multiple discrete cases
5. `_05_loops` — repeat operations
6. `_06_methods` — organise code into reusable units
7. `_07_strings` — work with text
8. `_08_output` — format and display results
9. `_09_userinput` — read data from the user
10. `_10_packages` — understand how Java organises code at scale
11. `_11_collections` — store, retrieve and manipulate groups of objects
12. `_13_intro_oop` — classes, objects, static vs instance, scope and encapsulation
13. `_12_exercices` — apply everything in a real exercise
