import java.util.Scanner;

/**
 * You are given a number x.
 * You need to perform the following operations till x gets converted to a single-digit number:
 * Step 1: Add all the digits of the number x.
 * Step 2: Now x becomes the sum of all its digits.
 * Step 3: Continue Step 1 and Step 2 until a single-digit number is obtained.
 *
 * For example:
 * x = 67
 * Sum of digits of 67 is 6+7 = 13.
 * New x = 13
 * Sum of digits of 13 is 1+3 = 4.
 * x = 4
 * Now x is a single-digit number.
 * Print x which is 4.
 */

public class SingleDigit {
    public static int singleDigitConversion(int x) {
        int result = 0;

        while(x != 0) {
            int pop = x % 10;
            System.out.println("Pop: " + pop);
            result += pop;
            System.out.println("Result: " + result);
            x /= 10;
            System.out.println("Number: " + x);
        }

        if(result >= 10) {
            x = result;
            result = 0;
            while(x != 0) {
                int pop = x % 10;
                System.out.println("Pop2: " + pop);
                result += pop;
                System.out.println("Result2: " + result);
                x /= 10;
                System.out.println("Number2: " + x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Prompt
        System.out.print("Please enter a number: ");
        Scanner sc = new Scanner(System.in);

        //Input
        int x = sc.nextInt();

        //Process / Output
        System.out.print(singleDigitConversion(x));
        sc.close();
    }
}
