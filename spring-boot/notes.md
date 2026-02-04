## Spring Boot — Core Concepts

**1. What Problem Does Spring Solve?**

Before Spring:
```
OrderService service = new OrderService(new PaymentServiceImpl());
```

Problems:

- tight coupling

- hard to test

- object creation scattered everywhere

- Spring solves object creation and wiring.


**2. Inversion of Control (IoC)**

Core idea

Control of object creation is inverted from the application to the framework.

You don’t create objects.
Spring does.

Without IoC
```
class OrderService {
    private PaymentService paymentService = new CardPaymentService();
}
```


❌ tightly coupled

❌ hard to change

With IoC
```
class OrderService {
    private PaymentService paymentService;
}
```

Spring decides:

- what to create

- when to create

- how to inject

📌 IoC is a design principle, not a Spring feature.


**3. Dependency Injection (DI)**

DI is how IoC is implemented.

Dependencies are provided from the outside.

**Constructor Injection (Best Practice)**
```
@Service
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

Why constructor injection?

- object is fully initialized

- supports immutability

- easy to test


**4. What is a Bean?**

A bean is an object managed by the Spring container.

Spring:

- creates it

- injects dependencies

- manages lifecycle

How Beans Are Created
```
@Component
public class PaymentService {}
```
or specialized:

@Service → business logic

@Repository → data access

@Controller → web layer

📌 These are semantic markers, not different objects.

**5. ApplicationContext (The Container)?**

The Spring container holds all beans.

Responsibilities:

- scan classes

- create objects

- wire dependencies

- manage lifecycle

You rarely touch it directly.

**6. Bean Lifecycle (High-Level)**

- Instantiate

- Inject dependencies

- Call init callbacks

- Bean ready for use

- Destroy on shutdown

📌 Important for resource management.

**7. Bean Scope**

| Scope     | Meaning                        |
| --------- | ------------------------------ |
| singleton | one instance per app (default) |
| prototype | new instance per request       |
| request   | per HTTP request               |
| session   | per user session               |


**8. How This Maps to OOP (Key Insight)**
| OOP Concept  | Spring Concept  |
| ------------ | --------------- |
| Object       | Bean            |
| Constructor  | Injection point |
| Interface    | Contract        |
| Polymorphism | Bean selection  |
| Composition  | Service wiring  |


**9. Why Spring Avoids 'new'**

Using new:

- hides dependencies

- breaks testability

- locks implementation

Spring prefers:

- constructor injection

- interfaces

- loose coupling

