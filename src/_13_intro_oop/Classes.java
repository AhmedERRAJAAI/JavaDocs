package _13_intro_oop;

// ─── Class Definition ─────────────────────────────────────────────────────────
// A class is a blueprint. It defines the fields (data) and methods (behaviour)
// that every object created from it will have.
class Car {

    // ─── Static Fields (Class Variables) ──────────────────────────────────────
    // Belong to the CLASS itself, not to any individual object.
    // Shared by ALL instances — changing it in one place changes it everywhere.
    static int totalCarsCreated = 0;
    static final String CATEGORY = "Automobile";   // constant: static + final

    // ─── Instance Fields (Instance Variables) ─────────────────────────────────
    // Each object gets its own independent copy of these.
    String brand;
    String model;
    int    year;
    double speed;         // current speed in km/h
    private double fuel;  // private: only accessible through methods of this class

    // ─── Constructor ──────────────────────────────────────────────────────────
    // Special method called when an object is instantiated with `new`.
    // Has no return type. Name must match the class name exactly.
    Car(String brand, String model, int year, double fuel) {
        // `this` refers to the current object being constructed.
        // It disambiguates between the parameter `brand` and the field `brand`.
        this.brand = brand;
        this.model = model;
        this.year  = year;
        this.fuel  = fuel;
        this.speed = 0;
        totalCarsCreated++;   // update the shared counter every time a Car is made
    }

    // ─── Overloaded Constructor ────────────────────────────────────────────────
    // Multiple constructors with different parameters — constructor overloading.
    Car(String brand, String model) {
        this(brand, model, 2024, 100.0);   // delegates to the full constructor
    }

    // ─── Instance Methods ─────────────────────────────────────────────────────
    // Operate on the data of a specific object. Called on an instance: car.accelerate(30)
    void accelerate(double amount) {
        if (fuel <= 0) {
            System.out.println(brand + " " + model + " is out of fuel!");
            return;
        }
        speed += amount;
        fuel  -= amount * 0.1;
        System.out.printf("%s %s accelerated to %.1f km/h (fuel: %.1f L)%n",
                brand, model, speed, fuel);
    }

    void brake() {
        speed = Math.max(0, speed - 20);
        System.out.printf("%s %s braked. Speed: %.1f km/h%n", brand, model, speed);
    }

    // Getter — controlled read access to a private field
    double getFuel() {
        return fuel;
    }

    // Setter — controlled write access with validation
    void refuel(double litres) {
        if (litres < 0) throw new IllegalArgumentException("Cannot add negative fuel");
        fuel += litres;
        System.out.printf("%s %s refuelled +%.1f L (total: %.1f L)%n",
                brand, model, litres, fuel);
    }

    // toString — called automatically when the object is used in a String context
    @Override
    public String toString() {
        return String.format("Car{%s %s, year=%d, speed=%.1f, fuel=%.1f}",
                brand, model, year, speed, fuel);
    }

    // ─── Static Method ────────────────────────────────────────────────────────
    // Belongs to the class, not to any instance.
    // Can only access static fields/methods — has no `this`.
    static void printStats() {
        System.out.println("Category: " + CATEGORY);
        System.out.println("Total cars created: " + totalCarsCreated);
    }
}


// ─── Second Class: demonstrates scope clearly ─────────────────────────────────
class Counter {
    // Static field — shared across all Counter objects
    static int instanceCount = 0;

    // Instance field — unique per object
    int count;
    String name;

    Counter(String name) {
        this.name  = name;
        this.count = 0;
        instanceCount++;
    }

    void increment() {
        // Local variable — exists only inside this method call
        int step = 1;           // local scope: born here, gone when method returns
        count += step;          // instance scope: persists on this object
    }

    void incrementBy(int amount) {
        // `amount` is a parameter — also local scope
        count += amount;
    }

    @Override
    public String toString() {
        return name + " → count=" + count;
    }
}


// ─── Main class ───────────────────────────────────────────────────────────────
public class Classes {
    public static void main(String[] args) {

        // ─── Instantiation ────────────────────────────────────────────────────
        // `new` allocates memory on the heap and calls the constructor.
        // The variable holds a REFERENCE (pointer) to the object, not the object itself.
        System.out.println("=== Instantiation ===");
        Car car1 = new Car("Toyota", "Corolla", 2020, 50.0);
        Car car2 = new Car("Honda",  "Civic",   2022, 40.0);
        Car car3 = new Car("BMW",    "M3");      // overloaded constructor

        System.out.println("car1: " + car1);
        System.out.println("car2: " + car2);
        System.out.println("car3: " + car3);

        // ─── Instance Methods & Fields ────────────────────────────────────────
        // Each object has its own state — car1 and car2 are independent.
        System.out.println("\n=== Instance Methods ===");
        car1.accelerate(60);
        car1.accelerate(40);
        car2.accelerate(30);
        car1.brake();
        System.out.println("car1 after: " + car1);
        System.out.println("car2 after: " + car2);   // car2 unaffected by car1's actions

        // ─── Static Fields & Methods ──────────────────────────────────────────
        // Access via the class name — no object needed.
        System.out.println("\n=== Static Fields & Methods ===");
        Car.printStats();   // called on the CLASS, not an instance

        // You can also access static fields via an instance, but it's discouraged
        // because it's misleading — the field doesn't belong to that object.
        System.out.println("car1.totalCarsCreated (misleading style): " + car1.totalCarsCreated);
        System.out.println("Car.totalCarsCreated  (correct style):    " + Car.totalCarsCreated);

        // ─── References vs Primitives ─────────────────────────────────────────
        System.out.println("\n=== References ===");
        Car ref1 = car1;        // ref1 and car1 point to the SAME object
        ref1.accelerate(10);    // modifies the same object car1 refers to
        System.out.println("car1 speed after ref1.accelerate: " + car1.speed);  // also changed

        // null — a reference that points to nothing
        Car empty = null;
        System.out.println("null reference: " + empty);
        // empty.accelerate(10);  // would throw NullPointerException at runtime

        // ─── Scope Demonstration ──────────────────────────────────────────────
        System.out.println("\n=== Scope ===");
        Counter c1 = new Counter("Alpha");
        Counter c2 = new Counter("Beta");

        c1.increment();
        c1.increment();
        c1.incrementBy(5);
        c2.increment();

        System.out.println(c1);    // Alpha → count=7
        System.out.println(c2);    // Beta  → count=1

        // Static field reflects total objects ever created (shared)
        System.out.println("Total Counter instances: " + Counter.instanceCount);

        // Block scope — variable only lives inside the block
        System.out.println("\n--- Block Scope ---");
        {
            int blockVar = 42;
            System.out.println("blockVar inside block: " + blockVar);
        }
        // System.out.println(blockVar);  // COMPILE ERROR: blockVar is out of scope

        // Loop variable scope
        for (int i = 0; i < 3; i++) {
            int loopLocal = i * 10;  // new variable each iteration
            System.out.println("loopLocal = " + loopLocal);
        }
        // System.out.println(i);  // COMPILE ERROR: i is out of scope

        // ─── Getters & Setters (Encapsulation) ────────────────────────────────
        System.out.println("\n=== Encapsulation (private field + getter/setter) ===");
        System.out.println("car1 fuel (via getter): " + car1.getFuel());
        car1.refuel(20);
        // car1.fuel = -999;  // COMPILE ERROR: field is private — cannot be set directly

        // ─── toString ─────────────────────────────────────────────────────────
        System.out.println("\n=== toString ===");
        System.out.println(car1);               // println calls toString() automatically
        System.out.println("String: " + car2);  // + operator also calls toString()
    }
}
