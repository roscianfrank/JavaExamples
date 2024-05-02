package JavaInterviewQuestions;

public class SumDigitsExample {

    public static int getSumOfAllDigits(int num) {

// Declare variable sum which will store the sum of all digits.
        int sum = 0;

// Run a while loop until the num becomes 0.
        while (num != 0) {
            int rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        return sum;

    }

    public static void main(String[] args) {

// We can pass any integer value of whose sum of the digits is required.
        System.out.println(getSumOfAllDigits(549));
    }

}