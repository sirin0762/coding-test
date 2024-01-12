package chapter4;

import java.util.Arrays;

public class Q_6_RETRY {

    public static void main(String[] args) {
        Q_6_RETRY main = new Q_6_RETRY();
        System.out.println(Arrays.toString(main.solution("0111010")));
    }

    public int[] solution(String s) {
        int removedZero = 0;
        int convertCount = 0;
        while (s.length() != 1) {
            int priorLength = s.length();
            s = s.replace("0", "");
            removedZero += priorLength - s.length();
            s = Integer.toString(s.length(), 2);
            convertCount++;
        }
        int[] answer = new int[2];
        answer[0] = convertCount;
        answer[1] = removedZero;
        return answer;
    }
}

