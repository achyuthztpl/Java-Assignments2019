package java_assignment_5.achyuth.assignment.main;

import java_assignment_5.achyuth.assignment.data.DefaultIntChar;
import java_assignment_5.achyuth.assignment.singleton.SingletonString;

public class Main {

    public static void main(String[] args) {

        DefaultIntChar defaultIntChar = new DefaultIntChar();
        defaultIntChar.printDefaultClassVariables();
        defaultIntChar.printDefaultLocalVariables();

        SingletonString singletonString = SingletonString.createSingletonString("achyuth");
        singletonString.printString();
    }
}
