package java_assignment_5.achyuth.assignment.singleton;

public class SingletonString {
    String str;

    public static SingletonString createSingletonString(String str) {
        SingletonString singletonString = new SingletonString();
        singletonString.str = str;
        return singletonString;
    }

    public void printString() {
        System.out.println("SingletonString object variable- "+str);
    }

}
