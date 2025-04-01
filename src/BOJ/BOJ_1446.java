package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_1446 {

    // 1. 주어진 도착지를 진행하며, dp를 적용한다.
    //      1. 점화식 : dp[i] = Math.min(dp[i - 1] + 1, dp[a] + route)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int D = input[1];

        int[] dp = new int[D + 1];

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodeList.add(new Node(input[0], input[1], input[2]));
        }

        for (int i = 1; i <= D; i++) {
            int destination = i;
            List<Node> sameDestinations = nodeList.stream().filter(n -> n.to == destination).collect(Collectors.toList());
            dp[destination] = dp[destination - 1] + 1;
            for (Node sd: sameDestinations) {
                dp[destination] = Math.min(dp[destination], dp[sd.from] + sd.distance);
            }
        }

        System.out.println(dp[D]);

    }

    static class Node {
        int from;
        int to;
        int distance;

        public Node(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

    }

}
