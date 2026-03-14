# Packages in Java

Packages are Java's mechanism for **organizing related classes and interfaces** into namespaces. They prevent naming conflicts, control access, and make large codebases navigable.

---

## 1. What is a Package?

A package is a **namespace** that groups related classes together. Every Java class belongs to exactly one package. If no `package` statement is present, the class belongs to the unnamed **default package** (fine for quick experiments; avoid in real projects).

```java
package com.myapp.utils;   // this class belongs to com.myapp.utils

public class StringUtils { ... }
```

Packages map directly to **directory structure**:

```
src/
└── com/
    └── myapp/
        └── utils/
            └── StringUtils.java
```

---

## 2. Declaring a Package

The `package` statement must be the **very first non-comment line** in the file:

```java
package com.example.myapp;   // ← must come first

import java.util.List;

public class MyClass { ... }
```

---

## 3. Package Naming Conventions

- All lowercase.
- Use **reverse domain name** to guarantee global uniqueness: `com.google.gson`, `org.apache.commons`.
- Components separated by dots; each dot corresponds to a directory level.
- Avoid using `java.*` or `javax.*` — those are reserved for the Java platform.

| Package                   | Owner            |
|---------------------------|------------------|
| `java.util`               | Java standard library |
| `com.google.gson`         | Google          |
| `org.springframework`     | Spring Framework|
| `io.netty`                | Netty project   |

---

## 4. Importing Classes

To use a class from another package, you must either **import** it or use its **fully qualified name**.

### Single-class import (preferred)
```java
import java.util.ArrayList;
import java.util.HashMap;
```

### Wildcard import (imports all classes in the package)
```java
import java.util.*;   // imports ArrayList, HashMap, Scanner, etc.
```

> Wildcard imports do **not** import sub-packages. `import java.util.*` does NOT import `java.util.concurrent.*`.

### Fully qualified name (no import needed)
```java
java.util.Date today = new java.util.Date();
```
Useful when two packages have classes with the same name (e.g., `java.util.Date` vs `java.sql.Date`).

### `java.lang` is automatic
Classes in `java.lang` — like `String`, `Math`, `System`, `Integer` — are imported **automatically**. You never need to write `import java.lang.String`.

---

## 5. Static Imports

Import **static members** (methods or fields) directly, so you can use them without the class prefix:

```java
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

double area = PI * sqrt(radius);   // instead of Math.PI * Math.sqrt(radius)
```

Useful for heavily used constants (`PI`, `E`) or methods (`abs`, `max`). Overusing them makes code harder to read — prefer sparingly.

---

## 6. Access Control & Packages

Packages interact closely with access modifiers:

| Modifier    | Same Class | Same Package | Subclass (other pkg) | Other Package |
|-------------|:----------:|:------------:|:--------------------:|:-------------:|
| `public`    | ✅          | ✅            | ✅                    | ✅             |
| `protected` | ✅          | ✅            | ✅                    | ❌             |
| *(default)* | ✅          | ✅            | ❌                    | ❌             |
| `private`   | ✅          | ❌            | ❌                    | ❌             |

**Package-private** (default, no modifier) is the default for class members. It enables classes within the same package to collaborate without exposing internals to the outside world.

---

## 7. Sub-packages

Sub-packages are separate and independent. They do **not** inherit access from their parent package.

```
java.util          ← one package
java.util.concurrent  ← completely separate package
```

```java
import java.util.*;              // imports ArrayList, Scanner, etc.
// java.util.concurrent.* is NOT included — must be imported separately:
import java.util.concurrent.*;
```

---

## 8. Package Structure in a Real Project

A typical Maven/Gradle project uses:

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                ├── model/
                │   └── User.java          (package com.example.model)
                ├── service/
                │   └── UserService.java   (package com.example.service)
                └── Main.java              (package com.example)
```

---

## 9. Key Takeaways

| Concept                   | Takeaway                                               |
|---------------------------|--------------------------------------------------------|
| `package` declaration     | Must be first line; maps to directory path             |
| Naming convention         | Reverse domain, all lowercase                          |
| `import`                  | Single-class or wildcard; `java.lang` is automatic     |
| Static import             | Use for frequently accessed constants/methods          |
| Default access            | Accessible within same package only                    |
| Sub-packages              | Independent; wildcard import does not include them     |
