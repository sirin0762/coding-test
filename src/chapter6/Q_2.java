package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Q_2 {

    // 1. 노란색 격자를 공약수를 통해 나눈다.
    // 2. 해당 공약수를 순회한다.
    // 3. 공약수의 (가로 + 2) * 2 + 세로 * 2 = brown이면 return 한다.

    public static void main(String[] args) {
        Q_2 q2 = new Q_2();
        q2.solution(10, 2);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int[] commonFactors = getCommonFactors(yellow);

        for (int i = 0; i < commonFactors.length; i++) {
            int row = commonFactors[i];
            int col = commonFactors[commonFactors.length - 1 - i];

            if ((col + 2) * 2 + row * 2 == brown) {
                return new int[]{col + 2, row + 2};
            }
        }

        return answer;
    }

    private int[] getCommonFactors(int yellow) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= (int)Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                result.add(i);
                result.add(yellow / i);
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }


}
