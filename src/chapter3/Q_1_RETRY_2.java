package chapter3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_1_RETRY_2 {

    private int maxX = 0;
    private int maxY = 0;

    public static void main(String[] args) {
        Q_1_RETRY_2 main = new Q_1_RETRY_2();
        String[] solution = main.solution(new int[][]
            {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
            }
        );
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(int[][] lines) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                if (isNotParallel(lines[i], lines[j])) {
                    Point point = getPoint(lines[i], lines[j]);
                    if (point != null) points.add(point);
                }
            }
        }

        List<char[]> map = new ArrayList<>();

        for (int i = -maxX; i <= maxX; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = -maxY; j <= maxY; j++) {
                sb.append(".");
            }
            map.add(sb.toString().toCharArray());
        }
        for (Point point: points) {
            map.get(point.y + maxY)[point.x + maxX] = '*';
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            char[] chars = map.get(maxY * 2 - i);
            result.add(new String(chars));
        }

        return result.toArray(new String[0]);
    }

    private Point getPoint(int[] line1, int[] line2) {
        int a = line1[0];
        int b = line1[1];
        int c = line2[0];
        int d = line2[1];
        int e = line1[2];
        int f = line2[2];

        double doubleX = (double) (b * f - e * d) / (a * d - b * c);
        double doubleY = (double) (e * c - a * f) / (a * d - b * c);

        int x = (b * f - e * d) / (a * d - b * c);
        int y = (e * c - a * f) / (a * d - b * c);

        if (doubleX != x || doubleY != y) return null;

        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);

        return new Point(x, y);
    }

    private boolean isNotParallel(int[] line1, int[] line2) {
        int a = line1[0];
        int b = line1[1];
        int c = line2[0];
        int d = line2[1];

        return (a * d - b * c) != 0;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
