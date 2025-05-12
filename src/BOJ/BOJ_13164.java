package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// 행복 유치원
public class BOJ_13164 {

    // 티셔츠 비용이 최소
    // 길이 차이 대로 잘라서 정렬하면 ?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];

        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            pq.add(new Cost(i, heights[i] - heights[i - 1]));
        }

        int cost = 0;
        for (int i = 0; i < N - K; i++) {
            cost += pq.poll().cost;
        }

        System.out.println(cost);
    }

    static class Cost implements Comparable<Cost> {
        public int index;
        public int cost;

        public Cost(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cost o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

}
