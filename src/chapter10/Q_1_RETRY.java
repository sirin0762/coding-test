package chapter10;

public class Q_1_RETRY {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int[] dp = new int[100001];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }

}
