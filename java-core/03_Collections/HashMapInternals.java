import java.util.*;

public class HashMapInternals {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("apple", 1);
        map.put("banana", 2);
        map.put("apple", 3);

        System.out.println(map); // apple -> 3
    }
}
