package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697 {

    private static final int INF = (int) 1e9;
    private static int answer = INF;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];
        Arrays.fill(arr, INF);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        arr[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                answer = arr[now];
                break;
            }
            if (now - 1 >= 0 && arr[now - 1] == INF) {
                q.add(now - 1);
                arr[now - 1] = arr[now] + 1;
            }

            if (now + 1 <= 100000 && arr[now + 1] == INF) {
                q.add(now + 1);
                arr[now + 1] = arr[now] + 1;
            }

            if (2 * now <= 100000 && arr[2 * now] == INF) {
                q.add(2 * now);
                arr[2 * now] = arr[now] + 1;
            }
        }

        System.out.println(answer);
    }

}
