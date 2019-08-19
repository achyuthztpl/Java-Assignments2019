package java_assignment_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Java_Assignment_1 {

    /**
     * The program searches through the home directory
     * and look for files that match a regular expression and prints out the file name and its absolute path.
     * It takes the regular expression repeatedly as input.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File home = new File("/home");
        Map homeDirectoryMap = new HashMap<String, String>();
        generateDirectoryMap(home, homeDirectoryMap);

        while (true) {
            AtomicInteger patternMatcherCount = new AtomicInteger();
            System.out.println("Enter the regular expression to find the file in Home directory:");
            String regularExpressionString = bufferedReader.readLine();

            try {
                Pattern regularExpressionPattern = Pattern.compile(regularExpressionString, Pattern.CASE_INSENSITIVE);
                homeDirectoryMap.forEach((key, value) -> {
                    if (regularExpressionPattern.matcher((String) value).find()) {
                        System.out.println(value + "--->" + key);
                        patternMatcherCount.getAndIncrement();
                    }
                });
            } catch (PatternSyntaxException e) {
                System.out.println("Given Regular Expression is Incorrect!! Please try again.");
            } catch (Exception e) {
                System.out.println("An Exception has been occurred! Please try again.");
            }

            if (patternMatcherCount.get() == 0)
                System.out.println("No matches found for the given regular expression in home directory.");

        }
    }

    /**
     * It add a key value pair into the given map in params.
     * It adds the key as the absolute file path and value as the file name
     * which are present in the given directory.
     *
     * @param presentDirectory The directory required to scan for files and later added to the directoryMap.
     * @param directoryMap     map containing key as the file's absolute path and value as its file name for each file in presentDirectory.
     */
    static void generateDirectoryMap(File presentDirectory, Map directoryMap) {
        if (presentDirectory == null)
            return;

        if (presentDirectory.isFile()) {
            directoryMap.put(presentDirectory.getAbsolutePath(), presentDirectory.getName());
            return;
        }

        File[] filesOrDirectories = presentDirectory.listFiles();
        if (filesOrDirectories != null)
            for (File fileOrDirectory : filesOrDirectories) {
                generateDirectoryMap(fileOrDirectory, directoryMap);
            }
    }

}