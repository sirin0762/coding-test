package chapter5;

import java.util.ArrayList;
import java.util.List;

public class Q_2 {

    List<int[]> hanois = new ArrayList<>();

    public static void main(String[] args) {
        Q_2 q2 = new Q_2();
        q2.solution(2);
    }

    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        return hanois.toArray(new int[0][]);
    }

    private void hanoi(int n, int from, int to) {
        if (n == 1) {
            hanois.add(new int[]{from, to});
            return;
        }
        int empty = 6 - from - to;
        hanoi(n - 1, from, empty);
        hanoi(1, from, to);
        hanoi(n - 1, empty, to);
    }

}
