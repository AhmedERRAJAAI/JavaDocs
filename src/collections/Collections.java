package collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        // ─── ArrayList ────────────────────────────────────────────────────────
        // Resizable array. Fast random access by index. Slow inserts/removals in the middle.
        // USE WHEN: you need indexed access and mostly add/remove at the end.
        System.out.println("=== ArrayList ===");
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Cherry");
        fruits.add(1, "Mango");             // insert at index 1
        System.out.println("List:         " + fruits);
        System.out.println("Get index 2:  " + fruits.get(2));
        System.out.println("Size:         " + fruits.size());
        fruits.remove("Apple");
        System.out.println("After remove: " + fruits);
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        java.util.Collections.sort(fruits);
        System.out.println("Sorted:       " + fruits);

        // ─── LinkedList ───────────────────────────────────────────────────────
        // Doubly-linked list. Fast inserts/removals anywhere. Slow random access.
        // USE WHEN: you frequently insert or remove from the middle or both ends.
        System.out.println("\n=== LinkedList ===");
        LinkedList<String> queue = new LinkedList<>();
        queue.addFirst("First");
        queue.addLast("Last");
        queue.add("Middle");
        System.out.println("LinkedList:    " + queue);
        System.out.println("Peek first:    " + queue.peekFirst());
        System.out.println("Peek last:     " + queue.peekLast());
        queue.removeFirst();
        System.out.println("After removeFirst: " + queue);

        // ─── HashSet ──────────────────────────────────────────────────────────
        // Hash-table backed set. No duplicates. No ordering guaranteed.
        // USE WHEN: you need fast membership checks and duplicates must be excluded.
        System.out.println("\n=== HashSet ===");
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red");            // duplicate — silently ignored
        System.out.println("HashSet (no duplicates, unordered): " + colors);
        System.out.println("Contains 'Blue'? " + colors.contains("Blue"));
        colors.remove("Green");
        System.out.println("After remove:  " + colors);

        // ─── LinkedHashSet ────────────────────────────────────────────────────
        // HashSet that preserves insertion order.
        // USE WHEN: you need no duplicates AND want predictable iteration order.
        System.out.println("\n=== LinkedHashSet ===");
        Set<String> linked = new LinkedHashSet<>();
        linked.add("Banana");
        linked.add("Apple");
        linked.add("Cherry");
        linked.add("Apple");          // duplicate — ignored
        System.out.println("LinkedHashSet (insertion order): " + linked);

        // ─── TreeSet ──────────────────────────────────────────────────────────
        // Red-black tree set. No duplicates. Always sorted in natural order.
        // USE WHEN: you need a sorted, unique collection and log(n) operations are acceptable.
        System.out.println("\n=== TreeSet ===");
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(42);
        numbers.add(7);
        numbers.add(100);
        numbers.add(7);               // duplicate — ignored
        numbers.add(23);
        System.out.println("TreeSet (always sorted):   " + numbers);
        System.out.println("First: " + ((TreeSet<Integer>) numbers).first());
        System.out.println("Last:  " + ((TreeSet<Integer>) numbers).last());
        System.out.println("HeadSet (< 42): " + ((TreeSet<Integer>) numbers).headSet(42));

        // ─── HashMap ──────────────────────────────────────────────────────────
        // Key-value store backed by a hash table. No ordering. O(1) average lookup.
        // USE WHEN: you need fast key-to-value lookup and don't care about order.
        System.out.println("\n=== HashMap ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob",   78);
        scores.put("Carol", 88);
        scores.put("Alice", 99);     // overwrites previous value for "Alice"
        System.out.println("HashMap (unordered): " + scores);
        System.out.println("Alice's score: " + scores.get("Alice"));
        System.out.println("Contains key 'Bob'? " + scores.containsKey("Bob"));
        scores.remove("Bob");
        System.out.println("After remove Bob: " + scores);

        // Iterating a Map
        System.out.println("Iterating entrySet:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.printf("  %-8s → %d%n", entry.getKey(), entry.getValue());
        }

        // getOrDefault — safe access when key may not exist
        System.out.println("Dave's score (default 0): " + scores.getOrDefault("Dave", 0));

        // putIfAbsent — only inserts if key is not already present
        scores.putIfAbsent("Alice", 0);   // Alice already exists — no change
        scores.putIfAbsent("Dave", 70);   // Dave doesn't exist — inserted
        System.out.println("After putIfAbsent: " + scores);

        // ─── LinkedHashMap ────────────────────────────────────────────────────
        // HashMap that preserves insertion order.
        // USE WHEN: you need key-value lookup AND predictable iteration order.
        System.out.println("\n=== LinkedHashMap ===");
        Map<String, String> capitals = new LinkedHashMap<>();
        capitals.put("France", "Paris");
        capitals.put("Japan",  "Tokyo");
        capitals.put("Brazil", "Brasília");
        System.out.println("LinkedHashMap (insertion order): " + capitals);

        // ─── TreeMap ──────────────────────────────────────────────────────────
        // Red-black tree map. Keys always sorted in natural order.
        // USE WHEN: you need a map AND want to iterate keys in sorted order.
        System.out.println("\n=== TreeMap ===");
        Map<String, Integer> ages = new TreeMap<>();
        ages.put("Charlie", 30);
        ages.put("Alice",   25);
        ages.put("Bob",     28);
        System.out.println("TreeMap (keys sorted): " + ages);
        System.out.println("First key: " + ((TreeMap<String, Integer>) ages).firstKey());
        System.out.println("Last key:  " + ((TreeMap<String, Integer>) ages).lastKey());

        // ─── ArrayDeque (Queue / Stack) ───────────────────────────────────────
        // Resizable double-ended queue. Faster than LinkedList for both queue and stack.
        // USE AS QUEUE WHEN: you need FIFO (first-in, first-out) processing.
        // USE AS STACK WHEN: you need LIFO (last-in, first-out) processing.
        System.out.println("\n=== ArrayDeque as Queue (FIFO) ===");
        Deque<String> fifoQueue = new ArrayDeque<>();
        fifoQueue.offer("Task 1");   // enqueue (add to tail)
        fifoQueue.offer("Task 2");
        fifoQueue.offer("Task 3");
        System.out.println("Queue: " + fifoQueue);
        System.out.println("Poll (removes head): " + fifoQueue.poll());
        System.out.println("Peek (reads head):   " + fifoQueue.peek());
        System.out.println("Queue after poll:    " + fifoQueue);

        System.out.println("\n=== ArrayDeque as Stack (LIFO) ===");
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Page 1");   // push to top
        stack.push("Page 2");
        stack.push("Page 3");
        System.out.println("Stack: " + stack);
        System.out.println("Pop (removes top): " + stack.pop());
        System.out.println("Peek (reads top):  " + stack.peek());
        System.out.println("Stack after pop:   " + stack);

        // ─── PriorityQueue ────────────────────────────────────────────────────
        // Min-heap by default. poll() always returns the smallest element.
        // USE WHEN: you need to process elements by priority, not insertion order.
        System.out.println("\n=== PriorityQueue ===");
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(50);
        pq.offer(20);
        System.out.print("PriorityQueue drain (min first): ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();

        // Max-heap using a custom comparator
        Queue<Integer> maxPq = new PriorityQueue<>(java.util.Comparator.reverseOrder());
        maxPq.offer(30);
        maxPq.offer(10);
        maxPq.offer(50);
        System.out.print("Max-heap drain (max first):      ");
        while (!maxPq.isEmpty()) {
            System.out.print(maxPq.poll() + " ");
        }
        System.out.println();

        // ─── java.util.Collections Utility Methods ────────────────────────────
        System.out.println("\n=== Collections Utility Methods ===");
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2));
        System.out.println("Original:       " + nums);
        java.util.Collections.sort(nums);
        System.out.println("Sorted:         " + nums);
        java.util.Collections.reverse(nums);
        System.out.println("Reversed:       " + nums);
        java.util.Collections.shuffle(nums, new Random(42));
        System.out.println("Shuffled:       " + nums);
        System.out.println("Min:            " + java.util.Collections.min(nums));
        System.out.println("Max:            " + java.util.Collections.max(nums));
        System.out.println("Frequency of 5: " + java.util.Collections.frequency(nums, 5));

        List<String> immutable = java.util.Collections.unmodifiableList(fruits);
        System.out.println("Unmodifiable list: " + immutable);
        // immutable.add("X");  // throws UnsupportedOperationException

        // List.of / Set.of / Map.of — compact immutable collections (Java 9+)
        System.out.println("\n=== Immutable Factories (Java 9+) ===");
        List<String> fixedList = List.of("A", "B", "C");
        Set<Integer> fixedSet  = Set.of(1, 2, 3);
        Map<String, Integer> fixedMap = Map.of("x", 10, "y", 20);
        System.out.println("List.of:  " + fixedList);
        System.out.println("Set.of:   " + fixedSet);
        System.out.println("Map.of:   " + fixedMap);
    }
}
