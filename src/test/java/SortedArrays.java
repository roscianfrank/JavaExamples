import java.util.Arrays;

public class SortedArrays {
    public static void main(String[] args) {
        descendingArray();
        ascendingArray();
    }

    public static void descendingArray() {
        int[] sortedArray = {20, 10, 30, 20, 50, 100};
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("Descending order array ================");
        Arrays.stream(sortedArray).forEach(System.out::println);
    }

    public static void ascendingArray() {
        int[] sortedArray = {20, 10, 30, 20, 50, 100};
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("Ascending order array ================");
        Arrays.stream(sortedArray).forEach(System.out::println);
    }
}


