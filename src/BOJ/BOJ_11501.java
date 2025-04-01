package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] stocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] profits = new int[n];

            for (int j = 1; j < n; j++) {
                profits[j] = getProfit(stocks, j);
            }

            int answer = 0;
            for(int profit: profits) {
                answer = Math.max(answer, profit);
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int getProfit(int[] stocks, int time) {
        int result = 0;
        int price = stocks[time];
        for (int i = 0; i < time; i++) {
            if (price > stocks[i]) result += price - stocks[i];
        }
        return result;
    }

}
