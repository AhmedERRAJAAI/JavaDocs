# Loops in Java

Loops allow you to execute a block of code repeatedly. Java has four main loop constructs, each suited for different scenarios.

---

## 1. `for` Loop

Use when you know **exactly how many times** you want to iterate.

**Syntax:**
```java
for (initialization; condition; update) {
    // body
}
```

**How it works:**
1. `initialization` — runs once before the first iteration (usually declares a counter).
2. `condition`      — checked before each iteration; loop stops when `false`.
3. `update`         — runs after each iteration (usually increments/decrements counter).

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);   // prints 0, 1, 2, 3, 4
}
```

**Common patterns:**

```java
// Counting backwards
for (int i = 10; i > 0; i--) { ... }

// Stepping by 2
for (int i = 0; i <= 10; i += 2) { ... }

// Iterating over an array with index
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

## 2. `while` Loop

Use when you want to repeat **as long as a condition holds**, and the number of iterations is not known in advance.

```java
while (condition) {
    // body — condition checked BEFORE each iteration
}
```

- If the condition is `false` from the start, the body **never executes**.

```java
int n = 1;
while (n <= 5) {
    System.out.println(n);
    n++;
}
```

**Classic use case — reading input until sentinel value:**
```java
Scanner sc = new Scanner(System.in);
int input;
while ((input = sc.nextInt()) != -1) {
    System.out.println("Got: " + input);
}
```

---

## 3. `do-while` Loop

Like `while`, but the condition is checked **after** the body executes — so the body always runs **at least once**.

```java
do {
    // body — condition checked AFTER each iteration
} while (condition);
```

```java
int k = 0;
do {
    System.out.println(k);
    k++;
} while (k < 3);   // prints 0, 1, 2
```

**Typical use case — menu driven programs:**
```java
int choice;
do {
    System.out.println("1. Start  2. Quit");
    choice = scanner.nextInt();
} while (choice != 2);
```

---

## 4. Enhanced `for` Loop (for-each)

The cleanest way to iterate over **arrays** and **collections** when you don't need the index.

```java
for (ElementType element : arrayOrCollection) {
    // use element
}
```

```java
int[] scores = {95, 88, 72, 60};
for (int score : scores) {
    System.out.println(score);
}

String[] colors = {"Red", "Green", "Blue"};
for (String color : colors) {
    System.out.println(color);
}
```

> **Limitation:** You cannot modify the original array through the loop variable, and you cannot track the index. Use a regular `for` loop when you need either.

---

## 5. `break` Statement

Immediately **exits** the enclosing loop (or `switch`).

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.print(i + " ");  // prints: 0 1 2 3 4
}
```

---

## 6. `continue` Statement

**Skips the rest of the current iteration** and jumps to the next one.

```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) continue;  // skip even numbers
    System.out.print(i + " ");  // prints: 1 3 5 7 9
}
```

---

## 7. Labeled `break` / `continue`

Used to break out of (or continue) an **outer loop** from inside a nested loop.

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) break outer;   // exits both loops
        System.out.println(i + "," + j);
    }
}
```

---

## 8. Nested Loops

A loop inside another loop. The inner loop completes all its iterations for each iteration of the outer loop.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.printf("%4d", i * j);
    }
    System.out.println();
}
```

Output (multiplication table):
```
   1   2   3
   2   4   6
   3   6   9
```

> **Performance note:** Nested loops multiply iteration counts. Two nested loops of n each = O(n²) operations.

---

## 9. Infinite Loops

A loop with a condition that is always `true`. Must be exited with `break` or `return`.

```java
while (true) {
    String input = scanner.nextLine();
    if (input.equals("quit")) break;
    process(input);
}
```

---

## Which Loop to Use?

| Situation                                  | Best choice      |
|--------------------------------------------|------------------|
| Known number of iterations                 | `for`            |
| Unknown iterations, condition-based        | `while`          |
| Must run at least once (e.g., menu)        | `do-while`       |
| Iterating all elements, no index needed    | Enhanced `for`   |
| Iterating with index, or modifying array   | Regular `for`    |

---

## Common Mistakes

| Mistake                 | Issue                               |
|-------------------------|-------------------------------------|
| `for (int i = 0; i <= arr.length; i++)` | Off-by-one: `arr[arr.length]` throws `ArrayIndexOutOfBoundsException` |
| Forgetting to increment in `while`      | Infinite loop                       |
| Modifying collection inside for-each    | `ConcurrentModificationException`   |
| Using `=` instead of `==` in condition  | Compile error in Java (assignment is not boolean) |
