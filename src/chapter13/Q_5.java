package chapter13;

import java.util.ArrayList;
import java.util.List;

public class Q_5 {

    int answer = Integer.MIN_VALUE;
    boolean[] visited;

    public static void main(String[] args) {
        Q_5 main = new Q_5();
        System.out.println(main.solution(
            new int[] {0,0,1,1,1,0,1,0,1,0,1,1},
            new int[][] {
                {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
            }
        ));
    }

    // 1. 말단이 늑대면 무조건 꺼져
    // 2. 그게 아니면 일단은 탐색, 이걸로 완탐
    public int solution(int[] info, int[][] edges) {
        Node[] nodes = new Node[info.length];

        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(i, info[i]);
        }
        for (int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];
            nodes[child].root = nodes[parent];
            if (nodes[parent].left == null) {
                nodes[parent].left = nodes[child];
            } else {
                nodes[parent].right = nodes[child];
            }

        }
        visited = new boolean[info.length];
        dfsLeft(nodes, 0, new ArrayList<Node>());

        visited = new boolean[info.length];
        dfsRight(nodes, 0, new ArrayList<Node>());
        return answer;
    }

    private void dfsLeft(Node[] nodes, int start, List<Node> list) {
        // 늑대이면서 양쪽에 볼게 없다면
        if (nodes[start].animalType == 1 && nodes[start].left == null && nodes[start].right == null) return;
        if (visited[start]) return;
        list.add(nodes[start]);

        if (!isOk(list)) {
            list.remove(list.size() - 1);
            return;
        }
        visited[start] = true;
        answer = (int) Math.max(answer, list.stream().filter(node -> node.animalType == 0).count());

        dfsLeft(nodes, nodes[start].left.number, list);
        dfsLeft(nodes, nodes[start].right.number, list);
    }

    private void dfsRight(Node[] nodes, int start, List<Node> list) {
        // 늑대이면서 양쪽에 볼게 없다면
        if (nodes[start].animalType == 1 && nodes[start].left == null && nodes[start].right == null) return;
        if (visited[start]) return;
        list.add(nodes[start]);

        if (!isOk(list)) {
            list.remove(list.size() - 1);
            return;
        }
        visited[start] = true;
        answer = (int) Math.max(answer, list.stream().filter(node -> node.animalType == 0).count());

        dfsRight(nodes, nodes[start].right.number, list);
        dfsRight(nodes, nodes[start].left.number, list);
    }

    private boolean isOk(List<Node> list) {
        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).animalType == 1) {
                wolf++;
            } else {
                sheep++;
            }
        }
        return sheep > wolf;
    }

    static class Node {
        int number;
        int animalType;
        Node root;
        Node left;
        Node right;

        public Node(int number, int animalType) {
            this.number = number;
            this.animalType = animalType;
        }

        public Node(int number, int animalType, Node root, Node left, Node right) {
            this.number = number;
            this.animalType = animalType;
            this.root = root;
            this.left = left;
            this.right = right;
        }

    }

}
