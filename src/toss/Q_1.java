package toss;

import java.util.Arrays;

public class Q_1 {

    public static void main(String[] args) {
        new Q_1().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }


    public int solution(int[] levels) {
        if (levels.length < 4) return  -1;
        Arrays.sort(levels);
        int standard = (int) Math.ceil(((double) levels.length / 4) * 3);
        return levels[standard];
    }
}
