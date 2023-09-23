import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        do {
            System.out.print("Enter the first number: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
            } else {
                // Check for invalid input like letters and symbols
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                continue;
            }

            System.out.print("Enter the second number: ");
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                continue;
            }
            // find difference between 2 inputs
            double difference = Math.abs(num1 - num2);

            // check to see if difference is less than 200
            if (difference < 200) {
                System.out.println("No output. Program will end.");
                break;
            }
            // check if input entered is float or integer
            if (isInteger(difference)) {
                System.out.println("The difference is an integer: " + (int) difference);
            } else {
                System.out.println("The difference is a float: " + difference);
            }

            switchTasks(num1, num2);

        } while (true);

        scanner.close();
    }

    public static void switchTasks(double num1, double num2) {
        // check to see which of the 2 inputs is larger
        double larger = Math.max(num1, num2);
        double smaller = Math.min(num1, num2);
        double sum = 0;

        for (int task = 1; task <= 3; task++) {
            switch (task) {
                case 1:
                    // Sum of input numbers that are even and divisible by 4
                    for (double i = smaller; i <= larger; i++) {
                        if (i % 2 == 0 && i % 4 == 0) {
                            sum += i;
                        }
                    }
                    System.out.println("Sum of even numbers divisible by 4: " + sum);
                    break;

                case 2:
                    // Sum of input numbers that are even and divisible by 8
                    sum = 0; // Reset the sum
                    for (double j = smaller; j <= larger; j++) {
                        if (j % 2 == 0 && j % 8 == 0) {
                            sum += j;
                        }
                    }
                    System.out.println("Sum of even numbers divisible by 8: " + sum);
                    break;

                case 3:
                    // Sum of input numbers that are not even and not divisible by 5
                    sum = 0; // Reset the sum
                    double k = smaller;
                    while (k <= larger) {
                        if (k % 2 != 0 && k % 5 != 0) {
                            sum += k;
                        }
                        k++;
                    }
                    System.out.println("Sum of numbers not even and not divisible by 5: " + sum);
                    break;
            }

        }

    }
    // check to see if input number is a whole integer
    public static boolean isInteger(double number) {
        return Math.floor(number) == number;
    }
}