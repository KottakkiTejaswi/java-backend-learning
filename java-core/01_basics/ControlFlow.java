public class ControlFlow {

    public static void main(String[] args) {

        // 1️⃣ if - else

        int age = 20;

        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }

        // 2️⃣ else-if ladder

        int marks = 75;

        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade D");
        }

        // 3️⃣ switch statement

        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 4️⃣ for loop

        for (int i = 1; i <= 5; i++) {
            System.out.println("For loop count: " + i);
        }

        // 5️⃣ while loop

        int count = 1;
        while (count <= 3) {
            System.out.println("While loop count: " + count);
            count++;
        }

        // 6️⃣ do-while loop

        int number = 1;
        do {
            System.out.println("Do-while count: " + number);
            number++;
        } while (number <= 2);

        // 7️⃣ break and continue

        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // skip 3
            }
            if (i == 5) {
                break; // stop loop
            }
            System.out.println("Value: " + i);
        }
    }
}
