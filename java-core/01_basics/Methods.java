public class MethodsAndParameters {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        int sum = add(a, b);
        System.out.println("Sum: " + sum);

        greet("Tejaswi");

        int result = square(4);
        System.out.println("Square: " + result);

        // Parameter passing example
        int number = 20;
        modifyValue(number);
        System.out.println("After method call: " + number);

        // Object parameter example
        Person person = new Person("Anu");
        changeName(person);
        System.out.println("Person name after method call: " + person.name);
    }

    // 1️⃣ Method with return value
    public static int add(int x, int y) {
        return x + y;
    }

    // 2️⃣ Method with no return value
    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    // 3️⃣ Method with single parameter
    public static int square(int number) {
        return number * number;
    }

    // 4️⃣ Primitive parameter passing
    public static void modifyValue(int num) {
        num = num + 10;
    }

    // 5️⃣ Object parameter passing
    public static void changeName(Person p) {
        p.name = "Changed Name";
    }
}

// Supporting class
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
