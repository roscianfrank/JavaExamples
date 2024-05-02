package JavaInterviewQuestions;

public class CheckArmstrongNumberExample {
    /*An Armstrong Number is a number in which the sum of the cubes of each digit is equal to the number itself.
    For ex:

            371 = 3*3*3 + 7*7*7 + 1*1*1

    The sum of the cubes is 3,7,1 is equal to 371.
    Another example is 153 which is an Armstrong number.
    You can explore other numbers too!!!
    Below is the Java Program to package$ the number is Armstrong or not.*/
    public static void main(String[] args) {

        int num = 371;
        int actualnum = num;
        double result = 0;

        while (actualnum != 0) {
            int n = actualnum % 10;
            result = result + Math.pow(n, 3);
            actualnum = actualnum / 10;
        }

        if (result == num) {
            System.out.println(num + " is an Armstrong number");
        } else {
            System.out.println(num + " is not an Armstrong number");
        }

    }

}