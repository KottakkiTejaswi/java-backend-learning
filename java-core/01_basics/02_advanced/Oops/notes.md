
## Object-Oriented Programming (OOP) Concepts – Java
**1. What is OOP?**

Object-Oriented Programming is a paradigm that structures software around objects — entities that combine state (data) and behavior (methods).

The goal of OOP is to:

- model real-world or domain concepts

- manage complexity

- build maintainable and extensible systems

**2. The Four Core OOP Principles**

**1️⃣ Encapsulation**

Encapsulation means bundling data and behavior together and restricting direct access to internal state.

Why it matters

- protects object integrity

- allows validation and invariants

- enables refactoring without breaking callers

Example
```
class Account {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```


📌 Internal state (balance) cannot be modified arbitrarily.

**2️⃣ Abstraction**

Abstraction focuses on what an object does, not how it does it.

Achieved using:

- interfaces

- abstract classes

Why it matters

- reduces coupling

- enables flexibility and testability

- supports multiple implementations

Example
```
interface PaymentService {
    void pay(double amount);
}
```


📌 Callers depend on behavior, not implementation.

**3️⃣ Inheritance**

Inheritance allows one class to acquire properties and behavior of another.
```
class Animal {
    void eat() {}
}

class Dog extends Animal {
    void bark() {}
}
```
Problems with overuse

- tight coupling

- fragile hierarchies

- harder to change base classes

📌 Prefer composition over inheritance in real systems.

**4️⃣ Polymorphism**

Polymorphism allows different objects to be treated through the same interface.
```
PaymentService service = new CardPayment();
service.pay(100);

```
At runtime, the correct implementation is chosen.

📌 This is how Spring dependency injection works.

**3. Class vs Object**
|   Concept	|   Description	|   
|---	    |---	        |
|   Class	|   	Blueprint or template	|   
|   Object	|   Real instance in memory	|   	


Objects live on the heap; references live on the stack.

**4. Constructors**

- used to initialize objects

- ensure objects start in a valid state

- default constructor exists only if no constructor is defined

```
class User {
    User(String name) {}
}
```

**5. this Keyword**

- refers to current object instance

- resolves naming conflicts

- improves readability

```
this.name = name;
```

**6. Access Modifiers**
|   Modifier	|   Scope	|   
|---	        |---	|
|   private	|   within class	|   	
|   default	|   	within package	|   	
|   protected	|   package + subclasses	|   
|   public	|   everywhere	|   
	

📌 Use the most restrictive access possible.

**7. Composition vs Inheritance**

```
Composition (preferred)
class Car {
    private Engine engine;
}

Inheritance (use carefully)
class Car extends Vehicle {}

```

📌 Composition leads to more flexible designs.

**8. Method Overloading vs Overriding**

**Overloading**

- same method name

- different parameters

- compile-time

```
add(int a, int b)
add(double a, double b)
```

**Overriding**

- subclass modifies parent behavior

- runtime polymorphism

```
@Override
void move() {}
```

**9. Interface vs Abstract Class**
|   Interface	|  Abstract Class 	|   
|---	        |---	|
|   multiple inheritance allowed	|  single inheritance 	|   	
|   no state (mostly)	|   can have state	|   
|   contract	|   partial implementation	|   
	

📌 Interfaces define capabilities, abstract classes define is-a relationships.

**10. Things to remember**

- Encapsulation protects state

- Abstraction reduces coupling

- Inheritance shares behavior (use sparingly)

- Polymorphism enables flexibility


