# Java Basics — Notes

## 1. Java Program Structure

- **Everything in Java is inside a class.**
- Java programs are **compiled into bytecode** and run on the **JVM (Java Virtual Machine)**.
- Execution starts at the **main method**:

=> public static void main(String[] args)

- Curly braces {} define code blocks.
- Statements end with a semicolon ;.
- System.out.println prints text to the console.

## 2. Data Types
**Primitive Types**

|   Type	|   Size	|   Example	|   	
|---	|---	|---	|
|   byte	|   8-bit	|   100	Small integers	| 
|   short	|   16-bit	|   30000	|   	
|   int	    |   32-bit	|   100000	| 
|   long	|   64-bit	|   1000000000L Large numbers	| 
|  float	|   32-bit	|   3.14f	Decimal numbers, single precision| 
|   double	|   64-bit	|   3.14159	Decimal numbers, double precision	| 
|   char	|   16-bit	|   'A'	Single character	| 
|   boolean	|   1-bit	|   true/false	Logical values	| 



**Non-Primitive (Wrapper/Object) Types**

String — sequence of characters, immutable.

Arrays — fixed-size collection of elements.

- Primitives are stored in stack memory.

- Objects (String, arrays, Integer, Double, Boolean, Character, Long, Float, Short, Byte etc.) are stored in heap memory and accessed via references.

🔹 Performance & Safety Considerations
Primitives:

- Faster execution

- Less memory usage

- No null checks required

- No auto-boxing/unboxing overhead

Wrapper Types:

- Slightly slower

- Risk of NullPointerException

- Necessary for collections and optional values

**Prefer primitive types when a value is mandatory and null has no meaning.**
**Use wrapper types when representing absence of value, working with collections, or handling external data.**

🔹 Relation to Spring Boot & Backend Systems

- Request/Response DTOs → Wrapper types

- Business logic → Primitive types

- Database entities → Wrapper types

- Configuration values → Primitive types

## 3. Variables

**Local variables**: declared inside a method, must be initialized before use.

**Instance variables**: declared in a class, default values assigned automatically.

**Static variables**: shared across all instances of a class.

**Syntax example**:
int age = 25;
String name = "Tejaswi";

## 4. Operators
Arithmetic: + - * / %

Comparison: == != > < >= <=

Logical: && || !

Assignment: = += -= *= /= %=

Increment/Decrement: ++, --

**Syntax example**
int a = 5, b = 10;
int sum = a + b; // 15
boolean isGreater = b > a; // true

## 5. Control Flow
**Conditional Statements**
if (condition) { ... } else { ... }
switch (variable) {
    case 1: ...
    break;
    default: ...
}

**if / else**

- Used for binary decisions

- Always use braces {} (clean code practice)

**else if**

- Evaluated top to bottom

- First matching condition executes

- Order conditions from most specific → least specific

**switch**

- Cleaner than long else-if chains

- Use break to avoid fall-through

**Loops**
- for, while, do-while

- Enhanced for loop:
  for (int num : array) { ... }

**break vs continue**

- break → exits loop completely

- continue → skips current iteration


🚨 Common  Mistakes 

❌ Infinite loops

❌ Missing break in switch

❌ Using == instead of .equals() for Strings

❌ Complex nested if blocks (bad readability)



## 6. Methods

Define reusable behavior inside a class.

```
public int add(int a, int b) {
    return a + b;
}
```

- Parameters vs Return type
- void → method does not return anything
- Methods help organize code and reduce duplication 

**What is a method?**

A method is a block of code that:

- performs a specific task

- can accept inputs (parameters)

- can return a value

=> returnType methodName(parameters)

**Parameters vs Arguments**

add(int x, int y)  // parameters
add(a, b)         // arguments


- Parameters → variables in method definition

- Arguments → actual values passed

**Return type**

- void → returns nothing

- Any other type → must return a value

public static void greet(String name) { ... }  // void
public static int add(int x, int y) { ... }    // returns int

❗ Java is PASS-BY-VALUE — always

- Java is strictly pass-by-value.
- For primitives, the value is copied.
- For objects, the reference is copied, so the object’s internal state can be modified, but the reference itself cannot be changed.

## 7. Arrays 
**What is an array?**
- An array is a fixed-size, indexed collection of elements

- All elements must be of the same type

- Stored in contiguous memory

```int[] numbers = new int[5];```

**Array Indexing**
- Index starts at 0
- Last index = length - 1
numbers[5]; // ArrayIndexOutOfBoundsException

**length property**
```numbers.length```

- length is a property, not a method

- No parentheses

**Enhanced for loop (for-each)**
```for (int num : numbers) { ... }```

- you don’t need the index

- you only want to read values

❌ Cannot modify the array index directly here

=> Arrays are objects

- Stored in heap

- Passed by reference value

- Can be modified inside methods

```public static void update(int[] arr) {
    arr[0] = 100;
}
```
**Default values in arrays**
|   Type	|   Default value	|   
|--------	|-------------	    |
|   int	    |   0	            |   	
|   double	|   0.0	            |   	
|   boolean	|  false            |   
|   object	|  null             |  	


🚨 Common mistakes

❌ Forgetting arrays are fixed size

❌ Off-by-one errors

❌ Using enhanced for when index is needed

❌ Assuming arrays auto-resize (they don’t)

## 8. Strings
- String objects are immutable

- Stored internally as a sequence of characters

- Extremely commonly used → heavily optimized by JVM

**What does immutability mean?**
Immutability = cannot be changed after creation

Once a String object is created, its value never changes.

```String s = "Hello";
s.concat(" World");
System.out.println(s);  // Hello
```


Why?

- concat() does not modify s

- It creates a new String object

Correct way:

```s = s.concat(" World");```

**Why does Java make String immutable?**
🔐 Security

Strings are used in:

- file paths

- database URLs

- class loaders

- environment variables

If strings were mutable, malicious code could modify values after validation.

🧵 Thread Safety

Immutable objects are inherently thread-safe.

- Multiple threads can share the same string safely.

♻️ String Pool Optimization

Immutability allows JVM to reuse strings safely.

**String Pool**
```
String a = "Java";
String b = "Java";
```

Both a and b point to the same object in the String Constant Pool.
But:
```String c = new String("Java");```
This creates:
one object in heap
one reference in pool (if not already present)

**String Comparision**
**==**

compares references

checks if both variables point to the same object

**.equals()**

compares content

📌 Always use .equals() for strings

**Common String Operations**

|  Operation 	      |  Example 	            |   	
|---	              |---	                    |
|   Length	          |   str.length()	        |   	
|  Character access   |  str.charAt(0) 	        |   	
|   Substring	      |   str.substring(1, 4)	|   
|   Contains	      |   str.contains("abc")	| 
|   Replace	          |   str.replace("a", "b")	| 
|   Case Change	      |   str.toUpperCase()	    | 
|   Trim     	      |   str.trim()            | 
|   Split     	      |   str.split(",")        | 

⚠️ All of these return new String objects.

**String Concatenation & Performance**
```
String s = "";
for (int i = 0; i < 1000; i++) {
    s += i;
}
```
❌ Inefficient because:

- creates many temporary String objects

- wastes memory

Better approach:
```
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String result = sb.toString();
```

**String vs StringBuilder vs StringBuffer**
|  Feature 	    |   String	|  StringBuilder 	|   StringBuffer	|   
|---	        |---	    |---	            |---	            |
|   Mutable	    |   ❌      |   	    ✅         |   	  ✅          |  
|   Thread-safe	|   ✅      |   	    ❌         |   	  ✅          |   
|   Performance	|   Slow    |   	Fast        |      Medium       | 

📌 Use cases:

String → constants, keys, configuration

StringBuilder → loops, dynamic text

StringBuffer → legacy multithreaded code

## 9. Object-Oriented Basics

- Class: blueprint for objects

- Object: instance of a class

- Encapsulation: using private fields + getters/setters

- Inheritance: extends keyword

- Polymorphism: method overloading (compile-time) & overriding (runtime)

- Abstraction: abstract classes & interfaces 

## 10. Exception Handling

- Use try-catch-finally to handle runtime errors:

```
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Always executes");
}
```
- Checked vs Unchecked exceptions

- Custom exceptions can extend Exception or RuntimeException


