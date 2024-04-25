package chapter9;

import java.util.Arrays;

public class Q_3_RETRY {

    public static void main(String[] args) {

    }

    public int solution(String before, String after) {
        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();

        Arrays.sort(beforeChars);
        Arrays.sort(afterChars);
        for (int i = 0; i < afterChars.length; i++) {
            if (beforeChars[i] != afterChars[i]) return 0;
        }
        return 1;
    }

}
