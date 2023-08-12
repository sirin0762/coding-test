package chapter5;

import java.util.ArrayList;
import java.util.List;

public class Q_3 {

    // 1. 주어진 단어를 통해 재귀를 이용하여 단어장을 만든다.
            // 1. 길이가 5 미만이면 -> A를 더해줌
            // 2. 길이가 5면, 마지막 알파벳을 바꿔줌
                // 2.1 U 일 경우 -> 마지막 알파벳 삭제 및 그 위의
    // 2. 정답의 위치를 찾는다.

    private char[] words = new char[]{'A', 'E', 'I', 'O', 'U'};
    private List<String> dictionary = new ArrayList<>();

    public static void main(String[] args) {
        Q_3 q3 = new Q_3();
        q3.solution("AAAAA");
    }

    public int solution(String word) {
        createDictionary("");
        return dictionary.indexOf(word);
    }

    private void createDictionary(String previous) {
        dictionary.add(previous);
        if (previous.length() == 5) {
            return;
        }
        for (char c: words) {
            String next = previous + c;
            createDictionary(next);
        }
    }

}
