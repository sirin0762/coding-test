package chapter5;

import java.util.Objects;

public class Q_3_RETRY {

    char[] chars = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    int answer = 0;

    public static void main(String[] args) {
        Q_3_RETRY main = new Q_3_RETRY();
        System.out.println(main.solution("EIO"));
    }

    public int solution(String word) {
        recursive(word, "");
        return answer;
    }

    private void recursive(String target, String word) {
        if (word.equals(target)) {
            answer = count;
            return;
        }
        if (word.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            if (answer != 0) break;
            count++;
            recursive(target, word + chars[i]);
        }
    }


}
