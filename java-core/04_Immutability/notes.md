## Immutability

**1. What is Immutability?**

An immutable object is an object whose state cannot change after creation.

Once constructed:

- fields don’t change

- object is thread-safe by default

- safe to use as Map keys, Set elements

**2. Why Immutability Matters (Real World)**

essential for:

- collections

- concurrency

- caching

- JPA entities 

- Spring beans

📌 Many Java bugs come from unexpected mutation.

**3. Mutable Object (Problematic)**

MutableUser.java
```
public class MutableUser {

    private String name;
    private int age;

    public MutableUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

❌ State can change anytime

❌ Dangerous as HashMap key

❌ Harder to reason about

** 4. Immutable Object (Correct)**

Rules for Immutability

- class is final

- fields are private final

- no setters

- defensive copies for mutable fields

```

public final class ImmutableUser {

    private final String name;
    private final int age;

    public ImmutableUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

```

✅ State cannot change

✅ Safe for collections

✅ Thread-safe

**5. equals() and hashCode() (Critical Contract)**

Why they matter

Used by:

- HashMap

- HashSet

- LinkedHashMap

- TreeSet (equals partly)

If wrong:

- duplicates appear

- lookups fail

- bugs are silent

**6. The Contract (Must Know)**

equals()

- reflexive

- symmetric

- transitive

- consistent

- x.equals(null) → false

hashCode()

- same object → same hashCode during lifetime

- equal objects → same hashCode

- unequal objects → can have same hashCode (collision allowed)

📌 Equal objects MUST have equal hashCodes

**7. Wrong Implementation Example**


❌ Only equals(), no hashCode():

```
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ImmutableUser)) return false;
    ImmutableUser user = (ImmutableUser) o;
    return age == user.age && name.equals(user.name);
}
```

**8. Correct Implementation**

EqualsHashCodeDemo.java

```
import java.util.Objects;

public final class EqualsHashCodeDemo {

    private final String name;
    private final int age;

    public EqualsHashCodeDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsHashCodeDemo that = (EqualsHashCodeDemo) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

**9.Test in Collections**

```
Set<EqualsHashCodeDemo> set = new HashSet<>();
set.add(new EqualsHashCodeDemo("A", 1));
set.add(new EqualsHashCodeDemo("A", 1));

System.out.println(set.size()); // 1
```

Without correct implementation → size becomes 2 ❌

