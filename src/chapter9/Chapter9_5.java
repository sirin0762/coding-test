package chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter9_5 {

    public static int n, m, c;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] distance;
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        c = input[2];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = input[0];
            int end = input[1];
            int distance = input[2];
            graph.get(start).add(new Node(end, distance));
        }

        djikstra(c);
        int count = -1;
        int max = 0;
        for (int i = 0; i < n + 1; i++) {
            if (distance[i] != INF) {
                count++;
                max = Math.max(max, distance[i]);
            }
        }

        System.out.println(count + " " + max);
    }

    private static void djikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (distance[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                Node next = graph.get(now).get(i);
                int cost = dist + next.getDistance();
                if (cost < distance[next.getIndex()]) {
                    distance[next.getIndex()] = cost;
                    pq.offer(new Node(next.getIndex(), cost));
                }
            }
        }
    }

}
