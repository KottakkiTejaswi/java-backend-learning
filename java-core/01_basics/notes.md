# Java Basics — Notes

## 1️⃣ Java Program Structure

- **Everything in Java is inside a class.**
- Java programs are **compiled into bytecode** and run on the **JVM (Java Virtual Machine)**.
- Execution starts at the **main method**:
public static void main(String[] args)
- Curly braces {} define code blocks.
- Statements end with a semicolon ;.
- System.out.println prints text to the console.

## 2️⃣ Data Types
**Primitive Types**
**Type**	**Size**	**Example	Notes**
byte	8-bit	100	Small integers
short	16-bit	30000	
int	    32-bit	100000	Most common integer type
long	64-bit	1000000000L	Large numbers
float	32-bit	3.14f	Decimal numbers, single precision
double	64-bit	3.14159	Decimal numbers, double precision
char	16-bit	'A'	Single character
boolean	1-bit	true/false	Logical values

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

## 3️⃣ Variables

**Local variables**: declared inside a method, must be initialized before use.

**Instance variables**: declared in a class, default values assigned automatically.

**Static variables**: shared across all instances of a class.

**Syntax example**:
int age = 25;
String name = "Tejaswi";

## 4️⃣ Operators
Arithmetic: + - * / %

Comparison: == != > < >= <=

Logical: && || !

Assignment: = += -= *= /= %=

Increment/Decrement: ++, --

**Syntax example**
int a = 5, b = 10;
int sum = a + b; // 15
boolean isGreater = b > a; // true

## 5️⃣ Control Flow
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


🚨 Common Beginner Mistakes 

❌ Infinite loops
❌ Missing break in switch
❌ Using == instead of .equals() for Strings
❌ Complex nested if blocks (bad readability)



## 6️⃣ Methods

Define reusable behavior inside a class.

public int add(int a, int b) {
    return a + b;
}

- Parameters vs Return type
- void → method does not return anything
- Methods help organize code and reduce duplication 

**What is a method?**

A method is a block of code that:

- performs a specific task

- can accept inputs (parameters)

- can return a value

**returnType methodName(parameters)**

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

## 7️⃣ Object-Oriented Basics

- Class: blueprint for objects

- Object: instance of a class

- Encapsulation: using private fields + getters/setters

- Inheritance: extends keyword

- Polymorphism: method overloading (compile-time) & overriding (runtime)

- Abstraction: abstract classes & interfaces

## 8️⃣ Exception Handling

- Use try-catch-finally to handle runtime errors:

try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Always executes");
}

- Checked vs Unchecked exceptions

- Custom exceptions can extend Exception or RuntimeException
