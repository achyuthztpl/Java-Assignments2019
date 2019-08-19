package java_assignment_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class RegularExpressionDemo {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("^[A-Z].*[.]$");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter a sentence:");
            if (pattern.matcher(bufferedReader.readLine()).find()) {
                System.out.println("The given statement successfully started with capital letter and ended with a period.");
            } else {
                System.out.println("The given statement neither started with capital letter or ended with a period.");
            }
        }
    }
}
