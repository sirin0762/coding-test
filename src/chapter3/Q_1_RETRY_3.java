package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q_1_RETRY_3 {

    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Q_1_RETRY_3 main = new Q_1_RETRY_3();
        String[] solution = main.solution(new int[][]
            {
                {0, 1, -1},
                {1, 0, -1},
                {1, 0, 1}
            }
        );
        System.out.println(Arrays.toString(solution));
    }
    // 1. 주어진 라인 2개를 순회하며 교점을 만든다.
    // 2. 교점이 성공적으로 만들어지면 교점 List에 추가한다.
    // 3. 교점을 모두 구한 뒤, x, -x, y, -y의 최댓값을 구해 그를 통해 별점을 찍는다.
    // 4. 가운데 0,0의 위치를 구한 뒤 해당 위치로 부터 진행한다.
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        // 1
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = makePoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (point != null) points.add(point);
            }
        }

        int row = maxX - minX + 1;
        int col = maxY - minY + 1;
        String[][] answer = new String[col][row];
        for (int i = 0; i < col; i++) {
            Arrays.fill(answer[i], ".");
        }
        for (Point point: points) {
            answer[maxY - point.y][point.x - minX] = "*";
        }
        String[] result = new String[col];
        for (int i = 0; i < col; i++) {
            result[col - 1 - i] = String.join("", answer[i]);
        }
        return result;
    }

    // 2
    private Point makePoint(long a, long b, long e, long c, long d, long f) {
        if (a * d - b * c == 0) return null;

        double x = (double) (b * f - e * d) / (a * d - b * c);
        double y = (double) (e * c - a * f) / (a * d - b * c);

        if ((int) x == x && (int) y == y) {
            minX = (int) Math.min(minX, x);
            maxX = (int) Math.max(maxX, x);
            minY = (int) Math.min(minY, y);
            maxY = (int) Math.max(maxY, x);
            return new Point((int) x,(int) y);
        }
        return null;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
