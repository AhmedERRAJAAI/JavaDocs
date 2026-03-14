# Collections in Java

The **Java Collections Framework (JCF)** provides a unified set of interfaces and classes for storing, retrieving, and manipulating groups of objects. Choosing the right collection for the job is one of the most important decisions you make in everyday Java programming.

---

## 1. The Collections Hierarchy

```
Iterable
└── Collection
    ├── List          (ordered, indexed, duplicates allowed)
    │   ├── ArrayList
    │   └── LinkedList
    ├── Set           (no duplicates)
    │   ├── HashSet
    │   ├── LinkedHashSet
    │   └── TreeSet
    └── Queue         (FIFO / priority-based processing)
        ├── LinkedList
        ├── ArrayDeque
        └── PriorityQueue

Map                   (key-value pairs, keys unique)
├── HashMap
├── LinkedHashMap
└── TreeMap
```

> `Map` does not extend `Collection`, but is part of the JCF.

---

## 2. List

An **ordered**, **indexed** sequence that allows **duplicate** elements.

### `ArrayList`

Backed by a resizable array. Index-based access is O(1). Adding/removing in the middle is O(n) because elements must be shifted.

```java
List<String> list = new ArrayList<>();
list.add("Banana");
list.add("Apple");
list.add(1, "Mango");     // insert at specific index
list.get(0);              // O(1) random access
list.remove("Apple");
Collections.sort(list);
```

**Use `ArrayList` when:**
- You need fast **random access** by index.
- You mostly add/remove at the **end**.
- You iterate over the list frequently.

---

### `LinkedList`

Backed by a doubly-linked list. Adding/removing at either end or in the middle is O(1) (given a reference). Index-based access is O(n).

```java
LinkedList<String> linked = new LinkedList<>();
linked.addFirst("First");
linked.addLast("Last");
linked.removeFirst();
linked.peekLast();
```

**Use `LinkedList` when:**
- You frequently **insert or remove in the middle** of the list.
- You need both **queue** and **stack** behavior (implements both `Queue` and `Deque`).
- You don't need fast index-based access.

---

## 3. Set

A collection that **does not allow duplicate** elements.

### `HashSet`

Backed by a hash table. No ordering. O(1) average for `add`, `remove`, `contains`.

```java
Set<String> set = new HashSet<>();
set.add("Red");
set.add("Red");      // ignored — already present
set.contains("Red"); // O(1)
```

**Use `HashSet` when:**
- You need the **fastest possible** membership check (`contains`).
- You don't care about iteration **order**.
- Uniqueness is the only requirement.

---

### `LinkedHashSet`

A `HashSet` that additionally maintains a **doubly-linked list** of insertion order, so iteration order matches the order elements were added.

```java
Set<String> linked = new LinkedHashSet<>();
linked.add("Banana");
linked.add("Apple");
linked.add("Banana");  // ignored
// iterates: Banana, Apple
```

**Use `LinkedHashSet` when:**
- You need **no duplicates** AND **predictable iteration order** (insertion order).
- Use case: de-duplicating a list while preserving the original sequence.

---

### `TreeSet`

Backed by a **red-black tree**. Always keeps elements in **sorted natural order** (or a custom `Comparator`). O(log n) for all operations.

```java
Set<Integer> tree = new TreeSet<>();
tree.add(42); tree.add(7); tree.add(23);
// iterates: 7, 23, 42

((TreeSet<Integer>) tree).first();         // smallest: 7
((TreeSet<Integer>) tree).headSet(23);     // elements < 23: [7]
((TreeSet<Integer>) tree).subSet(7, 42);   // elements in [7, 42): [7, 23]
```

**Use `TreeSet` when:**
- You need elements to always be in **sorted order**.
- You use **range queries** (`headSet`, `tailSet`, `subSet`).
- O(log n) performance is acceptable.

---

## 4. Map

Stores **key → value** pairs. Keys are unique; values can repeat.

### `HashMap`

Backed by a hash table. No ordering. O(1) average for `get`, `put`, `remove`.

```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 95);
map.get("Alice");                        // 95
map.getOrDefault("Dave", 0);            // 0 (key absent)
map.putIfAbsent("Bob", 80);             // only inserts if "Bob" not present
map.containsKey("Alice");               // true

for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " → " + e.getValue());
}
```

**Use `HashMap` when:**
- You need the **fastest key-value lookup**.
- Iteration **order doesn't matter**.
- This is the correct default choice for maps in most situations.

---

### `LinkedHashMap`

A `HashMap` that maintains **insertion order** (or optionally access order for LRU caches).

```java
Map<String, String> map = new LinkedHashMap<>();
map.put("France", "Paris");
map.put("Japan", "Tokyo");
// iterates: France, Japan (insertion order)
```

**Use `LinkedHashMap` when:**
- You need key-value lookup AND **predictable iteration order**.
- Building an **LRU cache** (`new LinkedHashMap<>(capacity, 0.75f, true)`).

---

### `TreeMap`

Backed by a **red-black tree**. Keys are always in **sorted natural order**. O(log n) operations.

```java
Map<String, Integer> map = new TreeMap<>();
map.put("Charlie", 30);
map.put("Alice", 25);
// iterates: Alice, Charlie (sorted keys)

((TreeMap<String, Integer>) map).firstKey();             // "Alice"
((TreeMap<String, Integer>) map).headMap("Charlie");     // keys < "Charlie"
```

**Use `TreeMap` when:**
- You need a map AND want to **iterate keys in sorted order**.
- You use **range queries** on keys.

---

## 5. Queue & Deque

### `ArrayDeque`

A resizable double-ended queue — the **recommended** implementation for both queue and stack use. Faster than `LinkedList` for both patterns.

**As a Queue (FIFO — First In, First Out):**
```java
Deque<String> queue = new ArrayDeque<>();
queue.offer("Task 1");   // enqueue (add to tail)
queue.offer("Task 2");
queue.poll();            // dequeue (remove from head) → "Task 1"
queue.peek();            // look at head without removing
```

**As a Stack (LIFO — Last In, First Out):**
```java
Deque<String> stack = new ArrayDeque<>();
stack.push("Page 1");   // push to top
stack.push("Page 2");
stack.pop();            // remove from top → "Page 2"
stack.peek();           // look at top without removing
```

**Use `ArrayDeque` when:**
- You need a **FIFO queue** (e.g., task processing, BFS traversal).
- You need a **LIFO stack** (e.g., undo history, DFS traversal, expression parsing).
- Prefer it over `Stack` (legacy) and `LinkedList` for these use cases.

---

### `PriorityQueue`

A **min-heap** by default: `poll()` always returns the smallest element, regardless of insertion order. Use a `Comparator.reverseOrder()` for a max-heap.

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(30); pq.offer(10); pq.offer(50);
pq.poll();   // → 10 (minimum)

// Max-heap
Queue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
```

**Use `PriorityQueue` when:**
- You need to process elements by **priority** (e.g., scheduling, Dijkstra's algorithm, top-K problems).

---

## 6. Quick Selection Guide

| Need                                         | Best choice          |
|----------------------------------------------|----------------------|
| Ordered list with fast index access           | `ArrayList`          |
| Frequent insertions/removals in the middle    | `LinkedList`         |
| Fast membership check, no duplicates          | `HashSet`            |
| No duplicates + preserve insertion order      | `LinkedHashSet`      |
| No duplicates + always sorted                 | `TreeSet`            |
| Key-value lookup, fastest                     | `HashMap`            |
| Key-value + insertion order                   | `LinkedHashMap`      |
| Key-value + sorted keys                       | `TreeMap`            |
| FIFO queue                                    | `ArrayDeque`         |
| LIFO stack                                    | `ArrayDeque`         |
| Process by priority (min/max)                 | `PriorityQueue`      |

---

## 7. Time Complexity Cheat Sheet

| Collection      | `add` | `get(i)` | `contains` | `remove` | Order          |
|-----------------|:-----:|:--------:|:----------:|:--------:|----------------|
| `ArrayList`     | O(1)* | O(1)     | O(n)       | O(n)     | Insertion      |
| `LinkedList`    | O(1)  | O(n)     | O(n)       | O(1)**   | Insertion      |
| `HashSet`       | O(1)  | —        | O(1)       | O(1)     | None           |
| `LinkedHashSet` | O(1)  | —        | O(1)       | O(1)     | Insertion      |
| `TreeSet`       | O(log n) | —     | O(log n)   | O(log n) | Sorted         |
| `HashMap`       | O(1)  | —        | O(1)       | O(1)     | None           |
| `LinkedHashMap` | O(1)  | —        | O(1)       | O(1)     | Insertion      |
| `TreeMap`       | O(log n) | —     | O(log n)   | O(log n) | Sorted keys    |
| `ArrayDeque`    | O(1)  | —        | O(n)       | O(1)     | FIFO / LIFO    |
| `PriorityQueue` | O(log n) | —     | O(n)       | O(log n) | Priority order |

\* Amortized O(1) — occasional resize is O(n). \** O(1) when removing at head/tail or via iterator.

---

## 8. The `Collections` Utility Class

`java.util.Collections` provides static methods that operate on any collection:

```java
Collections.sort(list);               // sort in natural order
Collections.sort(list, comparator);   // sort with custom comparator
Collections.reverse(list);            // reverse the list
Collections.shuffle(list);            // randomise order
Collections.min(collection);          // smallest element
Collections.max(collection);          // largest element
Collections.frequency(list, elem);    // count occurrences
Collections.unmodifiableList(list);   // read-only view
Collections.synchronizedList(list);   // thread-safe wrapper
```

---

## 9. Immutable Collections (Java 9+)

`List.of`, `Set.of`, and `Map.of` create compact, **unmodifiable** collections. Any attempt to add/remove throws `UnsupportedOperationException`.

```java
List<String> names  = List.of("Alice", "Bob", "Carol");
Set<Integer> primes = Set.of(2, 3, 5, 7, 11);
Map<String, Integer> codes = Map.of("USA", 1, "UK", 44, "DE", 49);
```

Prefer these over `Collections.unmodifiableList(...)` when the data is fixed at creation time.

---

## 10. Programming to the Interface

Always declare variables using the **interface type**, not the implementation. This makes it easy to swap implementations later:

```java
// Good — declared as List, not ArrayList
List<String> names = new ArrayList<>();

// Later you can change the implementation without touching any other code:
List<String> names = new LinkedList<>();
```

Same principle applies to `Set`, `Map`, `Queue`, and `Deque`.
