package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Q_1 {

    // 1. 주어진 정답 배열을 순회한다.
    // 2. 순회하며 정답인 경우 변수에 +1을 해준다.
    // 3. 순회 후 가장 높은 점수를 받은 사람을 찾는다.

    public static void main(String[] args) {

    }

    public int[] solution(int[] answers) {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (first[i % first.length] == answer) {
                scores[0]++;
            }
            if (second[i % second.length] == answer) {
                scores[1]++;
            }
            if (third[i % third.length] == answer) {
                scores[2]++;
            }
        }
        return bestScores(scores);
    }

    private int[] bestScores(int[] scores) {
        List<Integer> result = new ArrayList<>();

        int maxValue = Integer.MIN_VALUE;
        for (int score: scores) {
            maxValue = Math.max(score, maxValue);
        }

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxValue) result.add(i + 1);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
