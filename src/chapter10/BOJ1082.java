package chapter10;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1082 {

    private static int min = Integer.MAX_VALUE;
    private static int maxRoomNumber = Integer.MIN_VALUE;

    // 주어진 것에 대한 dfs로 완탐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value: p) {
            min = Math.min(min, value);
        }
        int m = Integer.parseInt(br.readLine());
        dfs(p, m, "");
        System.out.println(maxRoomNumber);
    }

    private static void dfs(int[] coins, int m, String str) {
        if (m < min) {
            maxRoomNumber = Math.max(maxRoomNumber, Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (m >= coins[i]) dfs(coins, m - coins[i], str + i);
        }
    }

}
