package java_assignment_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class KYCFormDateUpdate {

    final static long ONE_YEAR_TIMESTAMP = 31536000000L;
    final static long ONE_MONTH_TIMESTAMP = 2592000000L;

    /**
     * It takes input such that
     * - first line contains no.of test cases n
     * - next each of the n lines has two dates separated by space, sign-up date and the current date, in order.
     * The dates should be in dd-MM-yyyy format.
     * It prints the ranges of dates applicable for the new KYC application for each test cases.
     * @param args
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTestCases = Integer.parseInt(bufferedReader.readLine());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        while (noOfTestCases-- > 0) {
            String[] dateStrings = bufferedReader.readLine().split(" ");
            long[] updatedFormDate = UpdateFormDate(dateFormatter.parse(dateStrings[0]).getTime(), dateFormatter.parse(dateStrings[1]).getTime());
            if (updatedFormDate == null)
                System.out.println("No Range");
            else
                System.out.println(dateFormatter.format(updatedFormDate[0]) + " " + dateFormatter.format(updatedFormDate[1]));
        }
    }

    /**
     * It generates the range of date for the KYC application
     * w.r.t. the given sign-up date of KYC and present date on th KYC application
     *
     * @param signUpDate The first sign-up date for KYC
     * @param presentDate The present date on the KYC application
     * @return The range of dates in which the KYC application can have.
     */
    public static long[] UpdateFormDate(long signUpDate, long presentDate) {

        Calendar signUpDateCalendar = Calendar.getInstance();
        Calendar presentDateCalender = Calendar.getInstance();

        signUpDateCalendar.setTimeInMillis(signUpDate);
        presentDateCalender.setTimeInMillis(presentDate);

        long[] updatedDates = new long[2];

        int presentYear = presentDateCalender.get(Calendar.YEAR);

        Calendar presentNearestKYCDateCalendar = (Calendar) signUpDateCalendar.clone();
        presentNearestKYCDateCalendar.set(Calendar.YEAR, presentYear);
        /*System.out.println(presentYear+"---"+(presentNearestKYCDateCalendar.getTimeInMillis() - presentDate));
        System.out.println(Math.round((float)(presentNearestKYCDateCalendar.getTimeInMillis() - presentDate)/ONE_YEAR_TIMESTAMP));
        System.out.println(Math.round((presentNearestKYCDateCalendar.getTimeInMillis() - presentDate)/ONE_YEAR_TIMESTAMP));*/
        presentNearestKYCDateCalendar.set(Calendar.YEAR,
                presentYear - Math.round((float)(presentNearestKYCDateCalendar.getTimeInMillis() - presentDate)/ONE_YEAR_TIMESTAMP));

        updatedDates[0] = presentNearestKYCDateCalendar.getTimeInMillis() - ONE_MONTH_TIMESTAMP;
        updatedDates[1] = updatedDates[0] +  2 * ONE_MONTH_TIMESTAMP;


        if (updatedDates[0] > presentDate || updatedDates[0] <= signUpDate)
            return null;
        else if (updatedDates[1] > presentDate)
            updatedDates[1] =  presentDate;

        return updatedDates;
    }

}
