package java_assignment_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckAllAlphabet {

    /**
     * It takes a string from input and
     * prints whether the given string contains all the english alphabets or not,
     * repeatedly for each input.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter a String:");
            String inputString = bufferedReader.readLine();
            if (checkAllAlphabet(inputString))
                System.out.println("Given String contains all the english alphabets :)");
            else
                System.out.println("Given String don't contains all the english alphabets :(");
        }
    }

    /**
     * It checks whether the given word contains all the english characters or not.
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     * @param string String containing words or letters.
     * @return boolean
     * True if string contains all alphabets else False
     */
    static boolean checkAllAlphabet(String string) {

        boolean[] englishCharactersBooleanArray = new boolean[26];

        int englishCharacterFoundCount = 0;
        string = string.toLowerCase();
        for (int index = 0; index < string.length(); index++) {
            int characterIntValueFrom0 = string.charAt(index) - 'a';
            if (Character.isLetter(characterIntValueFrom0 + 'a') && !englishCharactersBooleanArray[characterIntValueFrom0]) {
                englishCharactersBooleanArray[characterIntValueFrom0] = true;
                englishCharacterFoundCount++;
            }
        }
        return englishCharacterFoundCount == 26;
    }
}
