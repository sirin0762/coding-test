package chapter11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_7 {

    public static void main(String[] args) {
        Q_7 main = new Q_7();
        System.out.println(Arrays.deepToString(main.solution(new int[][]{
            {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        })));
    }

    // 1. 노드 만들기
    // 2. 정렬하기
    // 3. 루트 노드를 기반으로 트리 만들기
    // 4. 전위, 후위 순회하기
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (n1, n2) -> Integer.compare(n2.y, n1.y));
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        int[][] answer = new int[2][];
        answer[0] = preOrder(root, new ArrayList<>()).stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrder(root, new ArrayList<>()).stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    private List<Integer> postOrder(Node node, List<Integer> integers) {
        if (node == null) return integers;

        postOrder(node.left, integers);
        postOrder(node.right, integers);
        integers.add(node.value);

        return integers;
    }

    private List<Integer> preOrder(Node node, List<Integer> integers) {
        if (node == null) return integers;

        integers.add(node.value);
        preOrder(node.left, integers);
        preOrder(node.right, integers);
        return integers;
    }


    private void insert(Node root, Node node) {
        if (root.x > node.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    public static class Node {
        int value;
        int x;
        int y;

        Node left;
        Node right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

    }

}
