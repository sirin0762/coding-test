package chapter10;

public class Q_2_RETRY {

    public static void main(String[] args) {

    }

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }

}
