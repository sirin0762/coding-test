package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주유소
public class BOJ_13305 {

    // 1. 내 다음 노드가 나보다 작을 떄
        // 거기까지 갈수 있을 만큼만 충전
    // 2. 내 다음 노드가 나보다 클 떄,
        // 그 다음 노드까지 풀충전
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long answer = 0;
        int minCost = costs[0];
        for (int i = 0; i < N - 1; i++) {
            if (costs[i] < minCost) {
                minCost = costs[i];
            }
            answer += (long) minCost * distance[i];
        }
        System.out.println(answer);
    }

}
