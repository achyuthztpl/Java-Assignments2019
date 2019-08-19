package java_assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class PingMedian {

    /**
     * It asks host address as input and
     * prints out the median of time taken to ping the given host address,
     * repeatedly for each input.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter a host address:");
            String hostInputString = bufferedReader.readLine();
            pingRequest(hostInputString);
        }

    }

    /**
     * It prints the median of time taken to ping the given host
     * using the system utility command 'ping'.
     *
     * @param host IP Address or Domain name.
     */
    public static void pingRequest(String host) {
        Runtime runtime = Runtime.getRuntime();
        String pingCommand = "ping " + host + " -c 10 -W 2 ";
        try {
            System.out.println("Maximum waiting time - 20 seconds.");
            Process process = runtime.exec(pingCommand);//8 counting from 1

            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String outputLine;
            List pingTimeList = new LinkedList<Float>();
            while ((outputLine = inputBufferedReader.readLine()) != null) {
                int searchIndex = -1;
                if ((searchIndex = outputLine.indexOf("time=")) != -1) {
                    pingTimeList.add(Float.parseFloat(outputLine.substring(searchIndex + 5, outputLine.lastIndexOf("ms") - 1)));
                }
            }

            int pingTimeListSize = pingTimeList.size();
            if (process.exitValue() != 0 || pingTimeListSize == 0) {
                System.out.println("Given host address doesn't exist or Unreachable.");
                return;
            }

            System.out.println("Ping time median - " + findMedian(pingTimeList));
        } catch (Exception ex) {
            System.out.println("Given host address doesn't exist or Unreachable or An internal error has occurred.");
        }

    }

    /**
     * It finds the median from the given list of float values
     *
     * @param numberList list of float values
     * @return median
     */
    public static Float findMedian(List numberList) {
        int numberListSize = numberList.size();
        numberList.sort((o, t1) -> (int) (((Float) o - (Float) t1) * 10));
        if (numberListSize % 2 == 0)
            return ((Float) numberList.get(numberListSize / 2) + (Float) numberList.get(numberListSize / 2 - 1)) / 2;
        return (Float) numberList.get(numberListSize / 2);
    }
}
