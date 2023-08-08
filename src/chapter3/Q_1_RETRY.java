package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_1_RETRY {

    // 1. 주어진 직선을 이용하여 교점을 구한다.
    // 2. 교점을 통해 모든 별을 포함하는 가장 작은 사각형을 만든다.
    // 3. 해당 포인트에 별을 찍는다.

    private static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Q_1_RETRY q1 = new Q_1_RETRY();
        int[][] line = {
            {2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
            {5, 8, 12}

//            {0, 1, -1},{1, 0, -1},{1, 0, 1}
        };
        String[] solution = q1.solution(line);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (point != null) {
                    points.add(point);
                }

            }
        }

        Point maxPoint = getMaximumPoint(points);
        Point minPoint = getMinimumPoint(points);

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(arr[i], '.');
        }

        for (Point point: points) {
            int row = (int) (point.y - minPoint.y);
            int col = (int) (point.x - minPoint.x);
            arr[row][col] = '*';
        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = new String(arr[arr.length - 1 - i]);
        }
        return answer;
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

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point: points) {
            x = Long.max(x, point.x);
            y = Long.max(y, point.y);
        }

        return new Point(x, y);
    }

    private Point intersection(long A, long B, long E, long C, long D, long F) {
        double x = (double) (B * F - E * D) / (A * D - B * C);
        double y = (double) (E * C - A * F) / (A * D - B * C);

        if (x % 1 == 0 && y % 1 == 0) return new Point((long) x, (long) y);
        return null;
    }



}
