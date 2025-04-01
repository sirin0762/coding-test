package Chapter6;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public int[] solution(int N, int[] stages) {
        FailRate[] failRates = new FailRate[N];
        Arrays.sort(stages);
        int reminder = stages.length;
        for (int i = 0 ; i <= N; i++) {
            int failMember = Collections.frequency(List.of(stages), i + 1);
            failRates[i] =
                new FailRate(
                    i + 1,
                    reminder,
                    failMember
                );
            reminder -= failMember;
        }

        Arrays.sort(failRates, Comparator.comparingDouble(f -> ((1.0) * f.n / f.p)));

        for (int i = 0; i < N; i++) {
            System.out.println(failRates[i].stage);
        }
        return new int[1];
    }
}

class FailRate {

    public int stage;
    public int p;
    public int n;

    public FailRate(int stage, int p, int n) {
        this.stage = stage;
        this.p = p;
        this.n = n;
    }

}
