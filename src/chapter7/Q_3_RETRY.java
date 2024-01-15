package chapter7;

import java.util.Arrays;

public class Q_3_RETRY {

    public static void main(String[] args) {
        Q_3_RETRY main = new Q_3_RETRY();
        System.out.println(main.solution(new int[] {12, 11, 10, 9, 8, 1}));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = citations.length; i >= 1; i--) {
            if (isValid(citations, i)) return i;
        }
        return answer;
    }

    private boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        return citations[index] >= h;
    }

}
