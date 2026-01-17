public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        } finally {
            System.out.println("Execution completed");
        }
    }
}
