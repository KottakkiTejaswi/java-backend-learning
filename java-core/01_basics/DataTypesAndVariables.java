public class DataTypesAndVariables {

    public static void main(String[] args) {

        // 1️⃣ Primitive Data Types

        int age = 25;
        double salary = 55000.75;
        boolean isEmployed = true;
        char grade = 'A';

        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Employed: " + isEmployed);
        System.out.println("Grade: " + grade);

        // 2️⃣ Type inference (Java 10+)
        var city = "Bangalore";   // compiler infers String
        var year = 2026;          // compiler infers int

        System.out.println("City: " + city);
        System.out.println("Year: " + year);

        // 3️⃣ Non-primitive type: String
        String name = "Tejaswi";
        System.out.println("Name: " + name);

        // 4️⃣ Final variables (constants)
        final double PI = 3.14159;
        System.out.println("PI: " + PI);

        // 5️⃣ Simple arithmetic
        int a = 10;
        int b = 3;

        int sum = a + b;
        int quotient = a / b;   // integer division
        double preciseQuotient = (double) a / b;

        System.out.println("Sum: " + sum);
        System.out.println("Quotient: " + quotient);
        System.out.println("Precise Quotient: " + preciseQuotient);
    }
}
