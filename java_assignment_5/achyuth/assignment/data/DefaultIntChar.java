package java_assignment_5.achyuth.assignment.data;

public class DefaultIntChar {
    int i;
    char c;

    public void printDefaultClassVariables() {
        System.out.println("Class Variables- "+i+" "+c);
    }

    public void printDefaultLocalVariables() {
        int i;
        char c;
        // There is no default value for local variables.
        // We need to initialize local variables before using them.

        /*System.out.println("Local Variables- "+i+" "+c);*/
    }

}
