package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 치킨거리
public class BOJ_15686 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Node> houses = new ArrayList<>();
    static List<Node> chickenRestaurants = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    // 가설 : 본인 지점에서 도시의 치킨거리가 최대이면 나가리가 아닐까?
    // 즉, 도시의 치킨거리를 각각 구해서, 작은 M개만 살리자!
    // 이후 map을 다시 그려서 치킨집 그려줌
    // 이후 도시의 치킨거리 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) houses.add(new Node(i, j));
                if (value == 2) chickenRestaurants.add(new Node(i, j));
            }
        }

        boolean[] visited = new boolean[chickenRestaurants.size()];
        dfs(chickenRestaurants, new Node[M], 0, visited);
        System.out.println(answer);
    }

    private static void dfs(List<Node> chickenRestaurants, Node[] nodes, int depth, boolean[] visited) {
        if (depth == nodes.length) {
            answer = Math.min(answer, getChickenLength(nodes));
            return;
        }

        for (int i = depth; i < chickenRestaurants.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nodes[depth] = chickenRestaurants.get(i);
            dfs(chickenRestaurants, nodes, depth + 1, visited);
            visited[i] = false;
        }
    }

    private static int getChickenLength(Node[] nodes) {
        int result = 0;
        for (Node house: houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Node chickenRestaurant: nodes) {
                minDistance = Math.min(minDistance, Math.abs(chickenRestaurant.x - house.x) + Math.abs(chickenRestaurant.y - house.y));
            }
            result += minDistance;
        }
        return result;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
