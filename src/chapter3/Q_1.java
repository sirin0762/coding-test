package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_1 {

    // 1. 주어진 직선을 이용하여 교점을 구한다.
        // 인풋을 조합으로 순회하며 교점을 뽑늗다.
    // 2. 그 중, 실수인 교점을 제거하고 정수인 교점을 찾는다.
    // 3. 교점 중, 가장 위, 아래, 좌, 우 의 교점의 좌표를 찾는다.
    // 4. 해당 교점의 좌표를 통해 *와 .을 출력한다.

    public List<Node> intersectionPoints = new ArrayList<>();
    public int up = -100_000;
    public int down = 100_000;
    public int right = -100_000;
    public int left = 100_000;

    public static void main(String[] args) {
        Q_1 q1 = new Q_1();
        int[][] line = {
//            {2, -1, 4},
//            {-2, -1, 4},
//            {0, -1, 1},
//            {5, -8, -12},
//            {5, 8, 12}

            {0, 1, -1},{1, 0, -1},{1, 0, 1}
        };
        String[] solution = q1.solution(line);
        System.out.println(solution);

    }

    public String[] solution(int[][] line) {
        for (int i = 0; i < line.length; i++) {
            int[] line1 = line[i];
            for (int j = 0; j < i + 1; j++) {
                int[] line2 = line[j];
                if (!isParallel(line1, line2) && haveIntegerIntersection(line1, line2)) intersectionPoints.add(getIntersectionPoint(line1, line2));
            }
        }
        return printRectagular();
    }

    private String[] printRectagular() {
        int row = up - down + 1;
        int col = right - left + 1;

        List<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            stringBuilders.add(new StringBuilder(".".repeat(col)));
        }
        Node center = new Node((col - 1) / 2, (row - 1) / 2);
        for (Node node: intersectionPoints) {
            stringBuilders.get(center.y + node.y).setCharAt(center.x + node.x, '*');
        }
        Collections.reverse(stringBuilders);
        return stringBuilders.stream().map(String::new).toArray(String[]::new);
    }

    private boolean haveIntegerIntersection(int[] line1, int[] line2) {
        int A = line1[0];
        int B = line1[1];
        int E = line1[2];
        int C = line2[0];
        int D = line2[1];
        int F = line2[2];

        double x = (double) (B * F - E * D) / (A * D - B * C);
        double y = (double) (E * C - A * F) / (A * D - B * C);
        int x1 = (B * F - E * D) / (A * D - B * C);
        int y1 = (E * C - A * F) / (A * D - B * C);

        return x == x1 && y == y1;
    }

    private Node getIntersectionPoint(int[] line1, int[] line2) {
        int A = line1[0];
        int B = line1[1];
        int E = line1[2];
        int C = line2[0];
        int D = line2[1];
        int F = line2[2];

        int x = (B * F - E * D) / (A * D - B * C);
        int y = (E * C - A * F) / (A * D - B * C);

        up = Integer.max(up, y);
        down = Integer.min(down, y);
        right = Integer.max(right, x);
        left = Integer.min(left, x);

        return new Node(x, y);
    }

    private boolean isParallel(int[] line1, int[] line2) {
        int A = line1[0];
        int B = line1[1];
        int C = line2[0];
        int D = line2[1];
        return (A * D - B * C) == 0;
    }

    private

}

