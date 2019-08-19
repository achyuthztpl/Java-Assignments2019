package java_assignment_11;

import java.io.*;
import java.util.*;

public class TestFileInOut {
    /**
     * It scans a file for the characters and store the count of each characters in a map and
     * prints the count values in a text file.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the file name:");
        String fileName = bufferedReader.readLine();

        File file = new File(fileName);
        if (file.isDirectory()) {
            System.out.println("Given file name is not a file.");
            return;
        }
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(file));
        Map<Character, Integer> characterCountMap = new TreeMap<Character, Integer>() ;

        String store;
        while ((store = fileBufferedReader.readLine()) != null)
            countCharacters(store, characterCountMap);

        StringBuilder stringBuilder = new StringBuilder();
        characterCountMap.forEach((character, integer) -> stringBuilder.append(character + "->" + integer+"\n"));

        PrintWriter filePrintWriter = new PrintWriter(new FileWriter("./output.txt"));
        filePrintWriter.print(stringBuilder.toString());

        filePrintWriter.close();
        fileBufferedReader.close();
    }

    /**
     * It counts the occurrence of characters and add them into the given map.
     * @param store
     * @param characterCountMap
     */
    private static void countCharacters(String store, Map<Character, Integer> characterCountMap) {
        int index = 0, storeLength = store.length();
        while (index < storeLength) {
            Character character = store.charAt(index);
            characterCountMap.put(character, characterCountMap.getOrDefault(character, 0) + 1);
            index++;
        }
    }

}
