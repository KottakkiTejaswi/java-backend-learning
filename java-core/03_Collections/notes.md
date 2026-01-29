
## Collections 

**1. What is the Collections Framework?**

The Java Collections Framework is a set of interfaces + implementations for storing and manipulating groups of objects.

Key idea:

- interfaces define contracts

- classes define behavior

This is abstraction + polymorphism in action.

**2. Core Interfaces**

Collection : 
- List
- Set
- Queue

-> Map (separate hierarchy)

Why Map is separate

- Map stores key–value pairs

- does not extend Collection

- different iteration semantics

**3. List Deep Dive**

List Characteristics

- ordered

- allows duplicates

- index-based access

Common Implementations
|   Implementation	|   	Use Case	|   
|---	|---	|
|  ArrayList 	|  frequent reads 	|   	
|   LinkedList	|   frequent inserts/removals (rarely needed)	|   

	
ArrayList vs LinkedList 
	
|   Aspect	|   ArrayList	|   LinkedList	|   	
|---	|---	|---	|
|  Access 	|   O(1)	|   O(n)	| 
|   Insert middle	|   O(n)	|   O(1) (after traversal)	|   	
|   Memory	|   compact	|   higher overhead	|   	


**4. Set Deep Dive**

Set Characteristics

- no duplicates

- uniqueness enforced

Implementations

|   Implementation	|   Behavior	|   	
|---	|---	|
|  HashSet 	|  unordered 	|   	
|   LinkedHashSet	|   insertion order	|   	
|   TreeSet	|  sorted 	|   

HashSet Internals 

- backed by a HashMap

- uniqueness depends on:

- hashCode()

- equals()

📌 If these are wrong → Set breaks.
	
**5. Map Deep Dive**

Map Characteristics

- key → value

- keys are unique

- values can be duplicated

Common Implementations
|   Map	|   Use Case	|   
|---	|---	|
|   HashMap	|   	general purpose	|   	
|   LinkedHashMap	|   predictable iteration	|   	
|   TreeMap	|   sorted keys	|   
|   ConcurrentHashMap	|   thread-safe|

**6. HashMap Internals**

How HashMap Works

- hashCode() called on key

- hash converted to bucket index

- equals() used to resolve collisions

Before Java 8:

- collisions → linked list

After Java 8:

- long chains → red-black tree

📌 This improves worst-case from O(n) to O(log n)

**7. equals() & hashCode() (Collections Contract)**

Rule 

- If two objects are equal according to equals(),
they must have the same hashCode().

Breaking this:

- causes bugs in HashMap / HashSet

- very hard to debug

**8. Fail-Fast Iterators**
```
List<String> list = new ArrayList<>();
for (String s : list) {
    list.add("X"); // ConcurrentModificationException
}
```
Why?

- iterator detects structural modification

📌 Use Iterator.remove() or concurrent collections.

**9. Choosing the Right Collection**
|   Need	|   Choose	|   	
|---	|---	|
|   Fast lookup	|   HashMap	|   	
|  Ordered data 	|   List	|   	
|   Unique elements	|   Set	|  
|   Thread safety	|    ConcurrentHashMap	|  	
	
	
	