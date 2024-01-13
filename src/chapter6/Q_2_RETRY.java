package chapter6;

import java.util.Arrays;

public class Q_2_RETRY {

    public static void main(String[] args) {
        Q_2_RETRY main = new Q_2_RETRY();
        System.out.println(Arrays.toString(main.solution(8, 1)));
    }

    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            int row = yellow / i;
            int col = i;

            int maybeBrownCount = getBrownCount(row, col);
            if (maybeBrownCount == brown) {
                return new int[]{row + 2, col + 2};
            }
        }
        return new int[2];
    }

    private int getBrownCount(int row, int col) {
        return (row + 2) * 2 + (col * 2);
    }

}
