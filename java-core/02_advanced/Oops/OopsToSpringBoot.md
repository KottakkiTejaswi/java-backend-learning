## Connecting OOP → Spring Boot 

1. **Encapsulation** → @Service, @Repository, @Controller

OOP idea:

- An object should hide its internal details and expose only meaningful behavior.

Spring Boot reality:
```
@Service
public class OrderService {

    public void placeOrder(Order order) {
        // business logic
    }
}
```

- Controllers don’t know how orders are placed

- Repositories don’t know why orders are placed

📌 Each layer encapsulates responsibility

2. **Abstraction** → Interfaces + Dependency Injection

OOP idea: 

- Program to an interface, not an implementation.

Spring Boot reality:
```
public interface PaymentService {
    void pay(double amount);
}
```
```
@Service
public class CardPaymentService implements PaymentService {
    public void pay(double amount) {}
}
```
```
@Autowired
private PaymentService paymentService;
```
📌 You don’t care which payment service

📌 You care that it can pay

That’s abstraction + polymorphism.

**3. Polymorphism** → Runtime Bean Selection
OOP idea

- Same interface, different behavior at runtime.

Spring Boot reality
```
@Service
@Qualifier("card")
class CardPaymentService implements PaymentService {}

@Service
@Qualifier("upi")
class UpiPaymentService implements PaymentService {}

```

Spring decides which implementation to inject at runtime.

📌 This is pure polymorphism, managed by the container.

**4. Constructors** → Constructor Injection (Immutability)

OOP idea

- Objects should be created in a valid, complete state.

Spring Boot reality
```
@Service
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

- dependencies are final

- object is immutable after creation

- no partial initialization

**5. Composition** → Bean Wiring

OOP idea

- Build complex objects by composing smaller ones.

```
@Service
class OrderService {
    private final PaymentService paymentService;
}
```
```
@Repository
class OrderRepository {}
```

- OrderService has a PaymentService
- OrderService has a OrderRepository


📌 Spring Boot applications are composition-heavy, not inheritance-heavy.

**6. Inheritance** → Used Sparingly in Spring

- Spring avoids inheritance for business logic.

Where it appears:

- framework base classes

- exception hierarchies

- configuration adapters

📌 This reinforces the OOP rule:

Prefer composition over inheritance


**7. Encapsulation** → Transaction Boundaries
```
@Transactional
public void placeOrder() {
    // atomic business operation
}

```


The caller:

- doesn’t know how transactions work

- doesn’t manage commits/rollbacks

📌 This is behavioral encapsulation.


**8. Exceptions** → Domain Modeling

OOP concept

- Exceptions represent invalid states.

Spring Boot reality

Handled centrally:

```
@ControllerAdvice
public class GlobalExceptionHandler {}
```

**9. Interfaces** → Testability

OOP principle

- Loose coupling enables substitution.

Spring Boot reality
```
@MockBean
PaymentService paymentService;
```

📌 Tests replace implementations without changing code.

This is why Spring apps are testable.

**10. Objects** → Beans
|   OOP	|  Spring Boot 	|  
|---	|---	|
|   Object	|   Bean	|   
|   Constructor	|   Dependency injection	|   	
|   Polymorphism	|   Runtime wiring	|   	
|   Composition	|   Service layering	| 
	

📌 Spring Boot is an object graph manager.



