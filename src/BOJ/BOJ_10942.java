package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 펠린드롬?
public class BOJ_10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] dp = new boolean[N][N];

        int M  = Integer.parseInt(br.readLine());
        // i : start
        for (int len = 0; len < N; len++) {
            for (int start = 0; start < N; start++) {
                int end = start + len;
                if (end >= N) break;

                if (len == 0) {
                    dp[start][end] = true;
                } else if (len == 1) {
                    dp[start][end] = (nums[start] == nums[end]);
                } else {
                    dp[start][end] = (nums[start] == nums[end]) && dp[start + 1][end - 1];
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean target = dp[input[0] - 1][input[1] - 1];
            bw.write((target ? "1" : "0" )+ "\n");
        }
        bw.flush();
        bw.close();
    }

}
