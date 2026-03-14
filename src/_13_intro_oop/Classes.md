# Classes & OOP Basics in Java

A **class** is a blueprint that describes what data an object holds and what it can do. An **object** is a live instance of that blueprint, created at runtime. This is the foundation of Object-Oriented Programming (OOP).

---

## 1. Anatomy of a Class

```java
class Car {
    // fields  — data the object holds
    String brand;
    int    year;

    // constructor — runs when the object is created
    Car(String brand, int year) {
        this.brand = brand;
        this.year  = year;
    }

    // method — behaviour the object can perform
    void describe() {
        System.out.println(brand + " (" + year + ")");
    }
}
```

| Part          | Purpose                                                    |
|---------------|------------------------------------------------------------|
| **Field**     | Stores state (data) for each object                        |
| **Constructor** | Initializes the object when `new` is called              |
| **Method**    | Defines behaviour; operates on the object's data           |

---

## 2. Instantiation

`new` allocates memory on the **heap** and calls the constructor. The result is a **reference** — a pointer to the object in memory.

```java
Car car1 = new Car("Toyota", 2020);
Car car2 = new Car("Honda",  2022);
```

- `car1` and `car2` are **independent** objects — each has its own copy of `brand` and `year`.
- The variable holds a **reference**, not the object itself.

### `null`

A reference that points to nothing. Calling any method on `null` throws a `NullPointerException`.

```java
Car empty = null;
empty.describe();   // NullPointerException at runtime!
```

### Reference Assignment

```java
Car ref = car1;     // ref and car1 point to the SAME object
ref.year = 2099;    // modifies the object that car1 also refers to
System.out.println(car1.year);  // 2099 — same object!
```

---

## 3. Instance Fields & Methods

**Instance** members belong to **each individual object**. Every object has its own copy of instance fields, and instance methods operate on those fields via `this`.

```java
class Counter {
    int count;   // instance field — each Counter object has its own `count`

    void increment() {
        count++;   // `count` refers to THIS object's count
    }
}

Counter a = new Counter();
Counter b = new Counter();
a.increment();
a.increment();
System.out.println(a.count);  // 2
System.out.println(b.count);  // 0 — b is completely unaffected
```

---

## 4. Static Fields & Methods

**Static** members belong to the **class itself**, not to any instance. They are shared by all objects and exist even before any object is created.

```java
class Car {
    static int totalCreated = 0;   // ONE shared copy for all Cars

    Car() {
        totalCreated++;            // every new Car increments the shared counter
    }

    static void printTotal() {     // no `this` — no object needed
        System.out.println("Cars made: " + totalCreated);
    }
}

Car c1 = new Car();
Car c2 = new Car();
Car.printTotal();   // "Cars made: 2" — called on the CLASS, not an instance
```

### When to use `static`

| Use `static` when…                               | Use instance when…                              |
|--------------------------------------------------|-------------------------------------------------|
| The value is shared across all objects            | The value is different per object               |
| The method doesn't need object state (`this`)    | The method reads or modifies object fields      |
| Utility/helper methods (like `Math.sqrt`)        | Behaviour tied to a specific object             |
| Constants (`static final`)                        |                                                 |

> **Rule:** Always access static members through the class name (`Car.totalCreated`), never through an instance variable. Accessing via an instance (`car1.totalCreated`) compiles but is misleading.

---

## 5. The `this` Keyword

`this` is a reference to the **current object** inside a method or constructor. Most commonly used to:

### Disambiguate field vs parameter names
```java
class Car {
    String brand;

    Car(String brand) {
        this.brand = brand;   // this.brand = field, brand = parameter
    }
}
```

### Delegate to another constructor
```java
Car(String brand, String model) {
    this(brand, model, 2024, 100.0);   // calls the full constructor
}
```

---

## 6. Constructors

A constructor is a special method with **no return type** and the **same name as the class**. It runs exactly once per object, immediately after memory is allocated by `new`.

```java
class Point {
    int x, y;

    Point()            { this(0, 0); }         // default position
    Point(int x, int y){ this.x = x; this.y = y; }  // custom position
}

Point origin = new Point();       // (0, 0)
Point p      = new Point(3, 4);   // (3, 4)
```

**Default constructor:** If you write no constructor at all, Java provides a no-arg one that sets all fields to their default values (`0`, `null`, `false`). Once you write any constructor, the default is removed.

---

## 7. Scope

Scope determines **where a variable is visible and how long it lives**.

### Local variables
Declared inside a method, constructor, or block. Live only within that block.

```java
void doSomething() {
    int x = 10;   // local — only exists here
}
// x doesn't exist here
```

### Instance variables (fields)
Declared inside the class but outside methods. Live as long as the object lives.

```java
class Dog {
    String name;   // instance scope — accessible in any method of this object
}
```

### Static variables (class variables)
Declared with `static`. Live as long as the class is loaded (typically the entire program).

```java
class Dog {
    static int count = 0;   // class scope — shared by all Dog objects
}
```

### Block scope
Variables declared inside `{}` are invisible outside that block.

```java
{
    int temp = 42;
    System.out.println(temp);  // fine
}
System.out.println(temp);      // COMPILE ERROR — temp is out of scope

for (int i = 0; i < 3; i++) { ... }
System.out.println(i);         // COMPILE ERROR — i is out of scope
```

### Scope summary

| Scope     | Declared in                  | Lives until              |
|-----------|------------------------------|--------------------------|
| Local     | Method / block / loop        | End of that block        |
| Instance  | Class body (no `static`)     | Object is garbage-collected |
| Static    | Class body with `static`     | Program exits            |
| Parameter | Method signature             | Method returns           |

---

## 8. Encapsulation — `private` + Getters/Setters

Hiding fields behind `private` and exposing controlled access through methods is called **encapsulation**. It lets you validate input and change the internal representation without breaking callers.

```java
class BankAccount {
    private double balance;   // no direct access from outside

    void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Must be positive");
        balance += amount;
    }

    double getBalance() { return balance; }
}

BankAccount acc = new BankAccount();
acc.deposit(100);
System.out.println(acc.getBalance());  // 100.0
// acc.balance = -9999;               // COMPILE ERROR — private
```

---

## 9. `toString`

Overriding `toString()` lets you control how an object appears in print statements and string concatenation.

```java
@Override
public String toString() {
    return "Car{" + brand + ", " + year + "}";
}

Car c = new Car("BMW", 2023);
System.out.println(c);          // Car{BMW, 2023}
System.out.println("My car: " + c);  // My car: Car{BMW, 2023}
```

Without `toString`, you get a meaningless default like `Car@7852e922`.

---

## 10. Summary

| Concept              | Keyword / syntax          | Belongs to    |
|----------------------|---------------------------|---------------|
| Instance field       | `String name;`            | Each object   |
| Static field         | `static int count;`       | The class     |
| Constant             | `static final int MAX;`   | The class     |
| Instance method      | `void drive() { ... }`    | Each object   |
| Static method        | `static void help() { }` | The class     |
| Constructor          | `Car(...) { ... }`        | —             |
| Current object ref   | `this`                    | Current object|
| Instantiation        | `Car c = new Car(...)`    | —             |
| Access control       | `private` / `public`      | —             |
