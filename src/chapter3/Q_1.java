package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_1 {

    // 1. 주어진 직선을 이용하여 교점을 구한다.
        // 인풋을 조합으로 순회하며 교점을 뽑늗다.
    // 2. 그 중, 실수인 교점을 제거하고 정수인 교점을 찾는다.
    // 3. 교점 중, 가장 위, 아래, 좌, 우 의 교점의 좌표를 찾는다.
    // 4. 해당 교점의 좌표를 통해 *와 .을 출력한다.


    public static void main(String[] args) {
        Q_1 q1 = new Q_1();
        int[][] line = {
            {2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
            {5, 8, 12}

//            {0, 1, -1},{1, 0, -1},{1, 0, 1}
        };
        String[] solution = q1.solution(line);
        System.out.println(solution);

    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point max = getMaximunPoint(points);
        Point min = getMinimumPoint(points);

        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);

        char[][] arr = new char[height][width];

        for (char[] row: arr) {
            Arrays.fill(row, '.');
        }

        for (Point p: points) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point: points) {
            x = Long.min(x, point.x);
            y = Long.min(y, point.y);
        }

        return new Point(x, y);
    }


    private Point getMaximunPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point: points) {
            x = Long.max(x, point.x);
            y = Long.max(y, point.y);
        }

        return new Point(x, y);
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    private static class Point {

        public final long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }

}
