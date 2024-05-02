package JavaInterviewQuestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SecondLargestElementOfArray {

    public static void main(String[] args) {

        int[] arr = {2,3,1,6,9,9};
        System.out.println("Second largest number is " + findSecondLargest(arr));
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //another solution
        //Arrays.sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
        for(int i = arr.length -2; i >=0; i--) {
            if(arr[i] != arr[arr.length-1]) {
                System.out.println("The second largest element " + arr[i]);
                break;
            }
        }

    }
    public static int findSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

}