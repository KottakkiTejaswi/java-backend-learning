class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old");
    }
}

public class ClassAndObject {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Tejaswi";
        p.age = 24;

        p.introduce();
    }
}
