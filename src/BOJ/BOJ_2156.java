package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] glasses = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            glasses[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = glasses[1];
        if (n >= 2) dp[2] = glasses[2] + glasses[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + glasses[i],
                             dp[i - 3] + glasses[i - 1] + glasses[i])
            );
        }

        System.out.println(dp[n]);
    }

}
