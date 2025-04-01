package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13549 {

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];
        int[] map = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        map[n] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                System.out.println(map[now]);
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                visited[now - 1] = true;
                map[now - 1] = map[now] + 1;
                q.add(now - 1);
            }

            if (now + 1 <= 100000 && !visited[now + 1]) {
                visited[now + 1] = true;
                map[now + 1] = map[now] + 1;
                q.add(now + 1);
            }

            if (now * 2 <= 100000 && !visited[now * 2]) {
                visited[now * 2] = true;
                map[now * 2] = map[now];
                q.add(now * 2);
            }
        }

    }

}
