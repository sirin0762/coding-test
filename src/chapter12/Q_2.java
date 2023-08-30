package chapter12;

import java.util.Map;

public class Q_2 {

    // 1. Map에 휴대폰 번호 위치를 넣는다.
    // 2. 찾아간다.
        // 2.1 1, 4, 7은 왼손
        // 2.2 3, 6, 9는 오른손
        // 2, 3, 5, 8은
            // 1. 거리 비교
            // 2. 같으면 두손 중에 주손으로

    public Coord left;
    public Coord right;

    public static void main(String[] args) {
        Q_2 q2 = new Q_2();
        q2.solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
    }

    public String solution(int[] numbers, String hand) {
        Map<Integer, Coord> phone = Map.of(
            1, new Coord(0, 3),
            2, new Coord(1, 3),
            3, new Coord(2, 3),
            4, new Coord(0, 2),
            5, new Coord(1, 2),
            6, new Coord(2, 2),
            7, new Coord(0, 1),
            8, new Coord(1, 1),
            9, new Coord(2, 1),
            0, new Coord(1, 0)
        );

        left = new Coord(0, 0);
        right = new Coord(2, 0);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(push(phone, number, hand));
        }

        return sb.toString();
    }

    private String push(Map<Integer, Coord> phone, int number, String hand) {
        Coord now = phone.get(number);

        String result = push(phone, number, now, hand);

        if (result.equals("L")) left = now;
        else right = now;

        return result;
    }

    private String push(Map<Integer, Coord> phone, int number, Coord now, String hand) {
        if (number == 1 || number == 4 || number == 7) return "L";
        if (number == 3 || number == 6 || number == 9) return "R";

        int leftDiff = left.compare(now);
        int rightDiff = right.compare(now);

        if (leftDiff > rightDiff) return "R";
        if (leftDiff < rightDiff) return "L";

        return hand.equals("left") ? "L" : "R";
    }

    private static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compare(Coord other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }

}
