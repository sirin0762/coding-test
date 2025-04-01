package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2531 {
    // 1. 주어진 벨트 돌면서 슬리이딩 윈도우
    // 2. 한바퀴 돌면 끗
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int d = input[1];
        int k = input[2];
        int c = input[3];
        int[] sushiCount = new int[d + 1];

        List<Integer> belt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            belt.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> sushi = new ArrayList<>();
        int left = 0;
        int right = k;
        int length = 1;
        int answer = 1;
        sushiCount[c]++;

        for (int i = left; i < right; i++) {
            sushi.add(belt.get(i));
            if (sushiCount[belt.get(i)] == 0) {
                length++;
                answer++;
            }
            sushiCount[belt.get(i)]++;
        }

        for (int i = 0; i < N; i++) {
            int rightTarget = belt.get(right);
            if (sushiCount[rightTarget] == 0) {
                length++;
            }
            sushiCount[rightTarget]++;
            right = (right + 1) % N;
            sushi.add(rightTarget);

            int leftTarget = belt.get(left);
            if (sushiCount[leftTarget] == 1) {
                length--;
            }
            sushiCount[leftTarget]--;
            left = (left + 1) % N;
            sushi.remove(0);

            answer = Math.max(answer, length);
        }

        System.out.println(answer);
    }

}
