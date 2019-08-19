package java_assignment_6;

public class OverloadingConstructor {
    OverloadingConstructor() {
        this("hello");
        System.out.println("In default Constructor");
    }

    OverloadingConstructor(String parameterString) {
        System.out.println("In another constructor with parameter string " + parameterString);
    }

    public static void main(String[] args) {
        OverloadingConstructor overloadingConstructor = new OverloadingConstructor();
    }
}
