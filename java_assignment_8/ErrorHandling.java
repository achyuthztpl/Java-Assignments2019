package java_assignment_8;

import java.util.Scanner;

public class ErrorHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        try {
            ThrowExceptionClass throwExceptionClass = new ThrowExceptionClass();
            throwExceptionClass.throwExceptions(sc.nextInt());
        } catch (Exception e) {
            System.out.println("Inside catch and exception is caught: " + e.getMessage());
        } finally {
            System.out.println("Inside finally.");
        }
    }
}

class ExceptionOne extends Exception {
    @Override
    public String getMessage() {
        return "It's ExceptionOne";
    }
}

class ExceptionTwo extends Exception {
    @Override
    public String getMessage() {
        return "It's ExceptionTwo";
    }
}

class ExceptionThree extends Exception {
    @Override
    public String getMessage() {
        return "It's ExceptionThree";
    }
}

class ThrowExceptionClass {

    void throwExceptions(int number) throws ExceptionOne, ExceptionTwo, ExceptionThree {
        if (number % 3 == 1)
            throw new ExceptionOne();
        else if (number % 3 == 2)
            throw new ExceptionTwo();
        else
            throw new ExceptionThree();
    }
}