import java.util.Scanner;

public class Ex1Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals(quit)) {
                // Printing the state of num1
                if (Ex1.isNumber(num1)) {
                    int value1 = Ex1.number2Int(num1);
                    System.out.println("num1= " + num1 + " is number: true , value: " + value1);
                } else {
                    System.out.println("num1= " + num1 + " is number: false , value: -1");
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                    continue;
                }

                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals(quit)) {
                    // Printing the state of num2
                    if (Ex1.isNumber(num2)) {
                        int value2 = Ex1.number2Int(num2);
                        System.out.println("num2= " + num2 + " is number: true , value: " + value2);

                        System.out.println("Enter a base for output: (a number [2,16]) ");
                        int base = sc.nextInt();

                        // Checking if the base is within the valid range
                        if (base < 2 || base > 16) {
                            System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                            continue;  // Continue asking the user until a valid base is chosen
                        }

                        // Calculating sum and product
                        String sum = Ex1.int2Number(Ex1.number2Int(num1) + Ex1.number2Int(num2), base);
                        String product = Ex1.int2Number(Ex1.number2Int(num1) * Ex1.number2Int(num2), base);

                        System.out.println(num1 + " + " + num2 + " = " + sum);
                        System.out.println(num1 + " * " + num2 + " = " + product);

                        // Finding the maximum in the array
                        String[] arr = {num1, num2, sum, product};
                        int maxIdx = Ex1.maxIndex(arr);
                        System.out.println("Max number over [" + String.join(",", arr) + "] is: " + arr[maxIdx]);
                    } else {
                        System.out.println("num2= " + num2 + " is number: false , value: -1");
                        System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                    }
                }
            }
        }
        System.out.println("quitting now...");
    }
}
