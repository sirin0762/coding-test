package chapter4;

public class Q_2_RETRY2 {

    public static void main(String[] args) {
        new Q_2_RETRY2().solution("a B z", 4);
    }

    public String solution(String s, int n) {
        String a = "";

        char[] answer = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) {
                answer[i] = c;
                continue;
            }
            if (Character.isUpperCase(c)) {
                c = (char) (c + n);
                if (c > 'Z') {
                    int move = c - 'Z';
                    c = (char) ('A' + move - 1);
                }
            } else {
                c = (char) (c + n);
                if (c > 'z') {
                    int move = c - 'z';
                    c = (char) ('a' + move  - 1);
                }
            }
            answer[i] = c;
        }

        return new String(answer);
    }

}
