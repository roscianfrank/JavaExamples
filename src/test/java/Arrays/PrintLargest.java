package Arrays;
// Java code to find largest three elements 
// in an array 

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

class PrintLargest {

    public static void main(String[] args) {

        max2();
        max3();
        max4();
        bubbleSort(new int[]{1, 2, 5, 4, 57, 54, 656, 4});
        questionMarkUse();

    }

    static void max2() {
        long startTime = System.nanoTime();
        Integer[] numbers = new Integer[]{1, 2, 5, 4, 57, 54, 656, 4};
        Arrays.sort(numbers, Collections.reverseOrder());

        int b[] = new int[2];

        b[0] = numbers[0];
        b[1] = numbers[1];
        System.out.println(b[0]);
        System.out.println(b[1]);
        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);
        System.out.println("Total time taken is " + totalTime);
    }

    static void max3() {
        long startTime = System.nanoTime();
        int[] numbers = new int[]{1, 2, 5, 4, 57, 54, 656, 4};
        int maxSize = 2;
        Arrays.stream(numbers) //stream
                .boxed()  //to Integer Object
                .sorted(Comparator.reverseOrder()) //sorted
                .limit(maxSize)  //keep N values
                .forEach(System.out::println);
        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);
        System.out.println("Total time taken is " + totalTime);
    }

    static void max4() {
        long startTime = System.nanoTime();
        int[] numbers = new int[]{1, 2, 5, 4, 57, 54, 656, 4};
        int temp = numbers[0];
        int max = temp;
        int lastMax = temp;

        for (int index = 1; index < numbers.length; index++) {
            int currentIndex = numbers[index];

            // check any time is it bigger than current maximum value
            max = Math.max(max, currentIndex);

            // if is grow up then should be max != temp; set old Max in last or
            // is not group up but current index is bigger then last index update last max value
            lastMax = max != temp ? temp : Math.max(currentIndex, lastMax);

            temp = max;
        }

        System.out.println("Last max: " + lastMax);
        System.out.println("Max:" + max);
        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);
        System.out.println("Total time taken is " + totalTime);
    }

    static void bubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);
        System.out.println("Total time taken is " + totalTime);
    }

    static void questionMarkUse(){
        //variable x = (expression) ? value if true : value if false
        int a, b;
        a = 10;
        b = (a == 1) ? 20: 30;
        System.out.println( "Value of b is : " +  b );

        b = (a == 10) ? 20: 30;
        System.out.println( "Value of b is : " + b );
    }
}