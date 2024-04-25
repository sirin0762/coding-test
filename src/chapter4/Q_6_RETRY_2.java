package chapter4;

import java.util.Objects;

public class Q_6_RETRY_2 {

    public static void main(String[] args) {
        new Q_6_RETRY_2().solution("0111010");
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;

        while (!Objects.equals(s, "1")) {
            String replaced =  s.replace("0", "");
            answer[1] = answer[1] + (s.length() - replaced.length());
            s = Integer.toBinaryString(replaced.length());
            count++;
        }
        answer[0] = count;
        return answer;
    }

}
