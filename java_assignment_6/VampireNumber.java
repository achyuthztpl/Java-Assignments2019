package java_assignment_6;

import java.util.ArrayList;
import java.util.Arrays;

public class VampireNumber {

    public static void main(String[] args) {
        ArrayList<Long> vampireList = new ArrayList<>();
        for (long number = 10; vampireList.size() <= 100; number++) {

            if (countDigit(number) % 2 != 0) {
                number = number * 10 - 1;
                continue;
            }
            for (long firstFactor = 2; firstFactor <= Math.sqrt(number) + 1; firstFactor++) {
                if (number % firstFactor == 0) {
                    long secondFactor = number / firstFactor;
                    if (isVampire(number, firstFactor, secondFactor)) {
                        vampireList.add(number);
                    }
                }
            }
        }
        System.out.println(vampireList);
    }

    /**
     * isVampire function checks if the given number isvampire based on the factors passed.
     *
     * @param number
     * @param firstFactor
     * @param secondFactor
     * @return
     */
    static boolean isVampire(long number, long firstFactor, long secondFactor) {
        if (firstFactor % 10 == 0 && secondFactor % 10 == 0)
            return false;

        if (countDigit(firstFactor) != countDigit(secondFactor) || countDigit(firstFactor) != countDigit(number) / 2)
            return false;

        char numberArray[] = Long.toString(number).toCharArray();
        char factorsArray[] = ("" + firstFactor + secondFactor).toCharArray();
        Arrays.sort(numberArray);
        Arrays.sort(factorsArray);

        return Arrays.equals(numberArray, factorsArray);

    }

    static int countDigit(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

}
