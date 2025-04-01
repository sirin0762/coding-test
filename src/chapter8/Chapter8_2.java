package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chapter8_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 2; i <= x; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            }

            if (i % 3 == 0) {
                dp[i] = dp[i / 3] + 1;
            }

            if (i % 5 == 0) {
                dp[i] = dp[i / 5] + 1;
            }

            dp[i] = Math.min(dp[i], dp[i - 1]  + 1);
        }
        System.out.println(dp[x]);
    }

}
