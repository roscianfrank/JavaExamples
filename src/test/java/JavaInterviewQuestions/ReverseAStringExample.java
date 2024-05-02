package JavaInterviewQuestions;

public class    ReverseAStringExample {

    public static void main(String[] args) {

        String inputString = "RoscianConsultancy";
        String outputString = "";

        /*
         * Writing a for loop and looping in the reverse order to get the reverse String
         * as output.
         */

        for (int i = inputString.length() - 1; i >= 0; i--) {
            outputString = outputString + inputString.charAt(i);
        }

        System.out.println(outputString);
    }

}