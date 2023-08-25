package chapter10;

import java.util.Arrays;

public class Q_2 {

    public static void main(String[] args) {

    }

    public int solution(int[][] triangle) {
        int[][] dp = triangle.clone();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if (j == dp[i].length - 1) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
            
        }
        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }

}
