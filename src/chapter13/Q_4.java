package chapter13;

import java.util.Arrays;

public class Q_4 {

    public int max = Integer.MIN_VALUE;
    public int[] answer = new int[11];

    public static void main(String[] args) {
        Q_4 main = new Q_4();
        System.out.println(Arrays.toString(main.solution(
            10,
            new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}
        )));
    }

    // 1. info를 통해 라이언이 해당 과녁의 점수를 얻기 위한 화살을 파악한다.
    // 2. 화살 개수, 점수를 객체로 만들어 list에 담는다.
    // 3. 조합을 통한 완전 탐색으로 가장 큰 값을 구한다.
    public int[] solution(int n, int[] info) {
        int[] peach = info;
        int[] lion = new int[11];

        for (int i = 0; i < peach.length; i++) {
            lion[i] = peach[i] + 1;
        }

        dfs(peach, lion, n, 0, new int[11]);
        return max > 0 ? answer : new int[]{-1};
    }

    // 종료 조건 : 화살을 다 쓴 경우, or 배열의 끝까지 진행한경우
    private void dfs(int[] peach, int[] lion, int remain, int start, int[] result) {
        if (remain == 0) {
            int score = getScore(peach, result);
            if (score > max) {
                max = score;
                answer = result.clone();
            } else if (score == max) {
                if (sameScoreCheck(answer, result)) {
                    answer = result.clone();
                }
            }
            return;
        }
        for (int i = start; i < lion.length; i++) {
            if (i == lion.length - 1) {
                result[i] = remain;
                dfs(peach, lion, 0, i + 1, result);
                result[i] = 0;
            }
            else if (remain > peach[i]) {
                result[i] = peach[i] + 1;
                remain -= result[i];
                dfs(peach, lion, remain, i + 1, result);
                remain += result[i];
                result[i] = 0;
            }
        }
    }

    private boolean sameScoreCheck(int[] answer, int[] result) {
        for (int i = answer.length - 1; i > 0; i--) {
            if (result[i] == 0 && answer[i] == 0) continue;
            return result[i] > answer[i];
        }
        return false;
    }

    private int getScore(int[] peach, int[] lion) {
        int peachScore = 0;
        int lionScore = 0;
        for (int i = 0; i < peach.length; i++) {
            if (peach[i] == 0 && lion[i] == 0) continue;

            if (peach[i] >= lion[i]) peachScore += 10 - i;
            else lionScore += 10 - i;
        }

        return lionScore - peachScore;
    }

}
