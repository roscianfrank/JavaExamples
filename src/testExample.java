import sun.jvm.hotspot.oops.Array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by roscian.frank on 07/07/2017.
 */
public class testExample {
    public static void main(String [ ] args){
        max2();
        arrayCheck();
        System.out.println(reverse("hello there"));
        System.out.println(reverseIt("hello there"));
        String string="hello there";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println(reverse);

        System.out.println("Please enter a string");
        Scanner in = new Scanner(System.in);
        String inpStr = in.nextLine();
        System.out.println("Original String :" + inpStr);
        char temp;
        char[] arr = inpStr.toCharArray();
        int len = arr.length;
        for(int i=0; i<(inpStr.length())/2; i++,len--){
            temp = arr[i];
            arr[i] = arr[len-1];
            arr[len-1] = temp;
        }

        System.out.println("Reverse String :" + String.valueOf(arr));

        String[] array = {"earth", "mars", "mercury"};
        Arrays.stream(array).map(s -> new StringBuilder(s).reverse().toString()).forEach(System.out::println);
    }
    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    public static String reverseIt(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }

    public static boolean arrayCheck(){
        int a[] =  {4,5,10,4,5};
        int b;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length-1;j++){
                if(a[i]==a[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean arrayCheckJava8(){
        boolean found=false;
        int a[] =  {4,5,10,4,5};
        Set<Integer> s = new HashSet<>();
        for (int name : a) {
            if (s.add(name) == found)
            {   System.out.println(name);
                found = true;
                return found;
            }
        }
        return found;
    }

    public static boolean streamArrys(){
        boolean duplicate=false;
        Integer[] numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
        Set<Integer> allItems = new HashSet<>();
        Set<Integer> duplicates = Arrays.stream(numbers)
                .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
                .collect(Collectors.toSet());
        System.out.println(duplicates);
        if(duplicates.size()>0){
            duplicate = true;
            return duplicate;
        }
        return duplicate;
    }

    public static void max2(){
        Integer[] numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
        Arrays.sort(numbers);
        for (int a : numbers) {
            System.out.println(a);
        }
        int b[] = new int [2];
        b[0] = numbers[0];
        b[1] = numbers[1];
        for (int a : b) {
            System.out.println(a);
        }

    }
}