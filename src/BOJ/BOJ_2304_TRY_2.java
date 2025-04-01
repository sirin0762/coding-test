package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_2304_TRY_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[1001];

        int start = 1000;
        int end = 0;
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int L = input[0];
            int H = input[1];
            map[L] = H;
            start = Math.min(start, L);
            end = Math.max(end, L);
        }

        int height = map[start];
        Stack<Integer> stack = new Stack<>();
        for (int i = start + 1; i <= end; i++) {
            if (map[i] <= height) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()) {
                    int leftPosition = stack.pop();
                    map[leftPosition] = height;
                }
                height = map[i];
            }
        }

        stack.clear();
        height = map[end];

        for (int i = end - 1; i >= start; i--) {
            if (map[i] <= height) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()) {
                    int rightPosition = stack.pop();
                    map[rightPosition] = height;
                }
                height = map[i];
            }
        }

        int result = 0;
        for (int i = start; i <= end; i++) {
            result += map[i];
        }
        System.out.println(result);
    }

}
