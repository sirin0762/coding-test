package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int x = input[1];

        int[] numbersOfGuest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int currentSum = getSumOfGuest(numbersOfGuest, 0, x);
        int answer = currentSum;
        int countOfPeriod = 1;
        for  (int i = 1; i <= n - x; i++) {
            currentSum += numbersOfGuest[i + x - 1];
            currentSum -= numbersOfGuest[i - 1];
            if (currentSum == answer) countOfPeriod++;
            if (currentSum > answer) {
                countOfPeriod = 1;
                answer = currentSum;
            }
        }

        if (answer == 0) {
            System.out.println("SAD");
            return;
        };

        System.out.println(answer);
        System.out.println(countOfPeriod);
    }

    private static int getSumOfGuest(int[] arr, int start, int length) {
        return Arrays.stream(Arrays.copyOfRange(arr, start, start + length)).sum();
    }

}
