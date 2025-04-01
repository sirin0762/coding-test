package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class BOJ_14888 {

    static boolean[] isVisited;
    static int[] numbers;
    static int MAX_VALUE = Integer.MIN_VALUE;
    static int MIN_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb.append("+".repeat(Integer.parseInt(st.nextToken())));
        sb.append("-".repeat(Integer.parseInt(st.nextToken())));
        sb.append("*".repeat(Integer.parseInt(st.nextToken())));
        sb.append("/".repeat(Integer.parseInt(st.nextToken())));
        char[] ops = sb.toString().toCharArray();
        int opsCount = ops.length;
        isVisited = new boolean[opsCount];

        dfs(ops, new char[opsCount], 0, opsCount);
        System.out.println(MAX_VALUE);
        System.out.println(MIN_VALUE);
    }

    private static void dfs(char[] ops, char[] result, int depth, int max) {
        if (depth == max) {
            int score = getScore(numbers, result);
            MAX_VALUE = Math.max(MAX_VALUE, score);
            MIN_VALUE = Math.min(MIN_VALUE, score);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            result[depth] = ops[i];
            dfs(ops, result, depth + 1, max);
            isVisited[i] = false;
        }
    }

    private static int getScore(int[] numbers, char[] ops) {
        int score = numbers[0];

        for (int i = 0; i < ops.length; i++) {
            if (ops[i] == '+') score += numbers[i + 1];
            if (ops[i] == '-') score -= numbers[i + 1];
            if (ops[i] == '*') score *= numbers[i + 1];
            if (ops[i] == '/') score /= numbers[i + 1];
        }

        return score;
    }

}
