package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 로프
public class BOJ_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            int weight = pq.poll();
            int maxWeight = weight * (pq.size() + 1);
            answer = Math.max(answer, maxWeight);
        }
        System.out.println(answer);
    }

}
