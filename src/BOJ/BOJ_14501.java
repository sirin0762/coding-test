package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 퇴사
public class BOJ_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            T[i] = input[0];
            P[i] = input[1];
        }

        for (int i = n; i > 0; i--) {
            int endDay = i + T[i];

            if (endDay <= n + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[endDay]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[1]);
    }
}
