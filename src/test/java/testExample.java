import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by roscian.frank on 07/07/2017.
 */
public class testExample {
    public static void main(String[] args) throws Exception {
        int array[]={12, 45, 45, 47, 90, 80,10,90};
        print2largest(array,array.length);

        System.out.println(Arrays.toString(max2()));
        System.out.println(doesNotContainInteger());
        Arrays.stream(getMovieTitles3("spiderman&page=1")).forEach(System.out::println);
        System.out.println(sumPyramidRow2(5));
        getMovieTitles("https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman");
        System.out.println(sumPyramidRow(5));
        stringPyramid();
        System.out.println(containsDuplicates2("Hello"));
        stringPyramid();
        containsDuplicates("Aple");
        System.out.println(isBalanced("Hello()"));
        System.out.println(max2());
        System.out.println(arrayCheck());
        System.out.println(reverse("hello there"));
        System.out.println(reverseIt("hello there"));
        String string = "hello there";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println(reverse);

        System.out.println("Please enter a string");
        Scanner in = new Scanner(System.in);
        String inpStr = in.nextLine();
        System.out.println("Original String :" + inpStr);
        char temp;
        char[] arr = inpStr.toCharArray();
        int len = arr.length;
        for (int i = 0; i < (inpStr.length()) / 2; i++, len--) {
            temp = arr[i];
            arr[i] = arr[len - 1];
            arr[len - 1] = temp;
        }

        System.out.println("Reverse String :" + String.valueOf(arr));

        String[] array1 = {"earth", "mars", "mercury"};
        Arrays.stream(array1).map(s -> new StringBuilder(s).reverse().toString()).forEach(System.out::println);
    }

    public static String reverse(String input) {
        char[] in = input.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    public static String reverseIt(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--) {
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }

    public static boolean arrayCheck() {
        int a[] = {4, 5, 10, 4, 5};
        int b;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i] == a[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean arrayCheckJava8() {
        boolean found = false;
        int a[] = {4, 5, 10, 4, 5};
        Set<Integer> s = new HashSet<>();
        for (int name : a) {
            if (s.add(name) == found) {
                System.out.println(name);
                found = true;
                return found;
            }
        }
        return found;
    }

    public static boolean streamArrys() {
        boolean duplicate = false;
        Integer[] numbers = new Integer[]{1, 2, 1, 3, 4, 4};
        Set<Integer> allItems = new HashSet<>();
        Set<Integer> duplicates = Arrays.stream(numbers)
                .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
                .collect(Collectors.toSet());
        System.out.println(duplicates);
        if (duplicates.size() > 0) {
            duplicate = true;
            return duplicate;
        }
        return duplicate;
    }

    public static int[] max2() {
        Integer[] numbers = new Integer[]{100, 2, 1, 3, 40, 4};
        Arrays.sort(numbers, Collections.reverseOrder());

        int b[] = new int[2];

        b[0] = numbers[0];
        b[1] = numbers[1];
        return b;
    }

    private static boolean isBalanced(String inputString) {
        if (inputString.contains("(") && inputString.contains(")")) {
            if (inputString.indexOf("(") < inputString.indexOf(")")) {
                return true;
            }
        }
        return false;
    }

    static boolean containsDuplicates(String value) {
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void stringPyramid() {

        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Enter the String : ");
        s = sc.nextLine();

        int len = s.length();
        String tmp = "";
        for (char c : s.toCharArray()) {
            tmp += tmp.length() > 0 ? " " + String.valueOf(c) : String.valueOf(c);
            System.out.printf("%" + (len + tmp.length() - 1) + "s\n", tmp);
            len--;
        }

    }

    private static boolean containsDuplicates2(String value) {
        char[] charArray = value.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : charArray) {
            if (map.containsKey(character)) {
                return true;
            } else {
                map.put(character, 1);
            }
        }

      /*  Set<Character> set = map.keySet();
        for(Character ch : set) {
            if(map.get(ch) > 1) {
                return true;
            }
        }*/
        return false;
    }

    static boolean containsDuplicates3(String value) {
        boolean foundDuplicate = false;
        int stringLength = value.length();
        Set<Character> characters = new HashSet<>(stringLength);
        for (int i = 0; i < stringLength; i++) {
            Character c = Character.valueOf(value.charAt(i));
            if (characters.contains(c)) {
                foundDuplicate = true;
                break;
            } else {
                characters.add(c);
            }
        }
        return foundDuplicate;
    }

    private static int sumPyramidRow(int row) {
        int rowSum = 1;
        int totalSum = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == row) {
                    totalSum += rowSum;
                }
                System.out.print(rowSum + " ");
                rowSum++;
            }
            System.out.println();
        }
        return totalSum;
    }

    public static ArrayList<String> title = new ArrayList<>();
    public static int counter = 0;


    private static String[] getMovieTitles(String substr) throws Exception {
        substr = "spiderman";
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print result
        System.out.println(response.toString());
        JsonElement jElement = new JsonParser().parse(response.toString());
        JsonObject jObject = jElement.getAsJsonObject();
        JsonArray jArray = jObject.getAsJsonArray("data");
        System.out.println(jArray);
        for (int i = 0; i < jArray.size(); i++) {
            jObject = jArray.get(i).getAsJsonObject();
            String result = jObject.get("Title").getAsString();
            title.add(result);
        }
        for (String s : title) {
            System.out.println(s);
        }
        while (counter == 0) {
            counter++;
            getMovieTitles(substr + "&page=2");
        }
        Collections.sort(title);
        System.out.println("===============================================================================================");
        for (String s : title) {
            System.out.println(s);
        }
        System.out.println("Total number of tital is : " + title.size());
        String[] stringTitle = new String[title.size()];
        stringTitle = title.toArray(stringTitle);
        return stringTitle;
    }

    static int sumPyramidRow2(int row) {
        int numberInRow = row;
        int firstNumber = ((row * (row - 1)) / 2) + 1;
        int sum = 0;
        for (int j = 0; j < numberInRow; j++) {
            sum += firstNumber + j;

        }


        return sum;

    }

    static String[] getMovieTitles3(String substr) throws Exception {
        String content = readUrl("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(content);
        Map<String, Object> json = (Map<String, Object>) engine.eval("(" + content + ");");
        int totalPages = (int) json.get("total_pages");
        String page = String.valueOf(json.get("page"));

        List<Map<String, Object>> data = ((ScriptObjectMirror) json.get("data")).to(List.class);

        List<String> titles = new ArrayList<>();

        data.stream().map(movie -> movie.get("Title")).forEach(title -> titles.add((String) title));

        return titles.toArray(new String[]{});
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    public static int doesNotContainInteger() {
        int[] A = {1,5,3, 6, 4, 1, 2};
        int num = 1;
        HashSet<Integer> hset = new HashSet<Integer>();
        for (int i = 0 ; i < A.length; i++) {
            hset.add(A[i]);//0
            while (hset.contains(num)) {//1 false
                num++;
            }
        }
        hset.forEach(System.out::println);
        return num;
    }
    public static void print2largest(int arr[], int arr_size)
    {
        int i, first, second, third;

        /* There should be atleast two elements */
        if (arr_size < 3)
        {
            System.out.print(" Invalid Input ");
            return;
        }

        third = first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than
            first*/
            if (arr[i] > first)
            {
                third = second;
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
            second then update second  */
            else if (arr[i] > second)
            {
                third = second;
                second = arr[i];
            }

            else if (arr[i] > third)
                third = arr[i];
        }

        System.out.println("Three largest elements are " +
                first + " " + second + " " + third);
    }
}

