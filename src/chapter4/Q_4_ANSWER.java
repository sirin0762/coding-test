package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Q_4_ANSWER {

    public static void main(String[] args) {

    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            min = Math.min(min, compress(s, length));
        }
        return min;
    }

    private int compress(String s, int length) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token: split(s, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }

    private List<String> split(String s, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > s.length()) endIndex = s.length();
            tokens.add(s.substring(startIndex, endIndex));
        }
        return tokens;
    }

}
