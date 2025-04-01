package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chapter8_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);
        int answer = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

}
