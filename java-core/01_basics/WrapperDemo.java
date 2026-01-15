public class WrapperDemo {

    public static void main(String[] args) {

        int primitive = 10;
        Integer wrapped = 10;

        System.out.println(primitive);
        System.out.println(wrapped);

        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);      // true

        Integer x = 200;
        Integer y = 200;
        System.out.println(x == y);      // false

        System.out.println(x.equals(y)); // true
    }
}
