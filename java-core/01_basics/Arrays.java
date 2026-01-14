public class ArraysExample {

    public static void main(String[] args) {

        // 1️⃣ Declaring and initializing an array
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("First element: " + numbers[0]);
        System.out.println("Array length: " + numbers.length);

        // 2️⃣ Iterating using for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("For loop value: " + numbers[i]);
        }

        // 3️⃣ Enhanced for loop (for-each)
        for (int num : numbers) {
            System.out.println("Enhanced for value: " + num);
        }

        // 4️⃣ Modifying array elements
        numbers[2] = 99;
        System.out.println("Modified third element: " + numbers[2]);

        // 5️⃣ Array with default values
        int[] scores = new int[3];
        System.out.println("Default value at index 0: " + scores[0]);

        // 6️⃣ String array
        String[] names = {"Anu", "Ravi", "Meera"};

        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
