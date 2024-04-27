package toss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q_2 {

    public static void main(String[] args) {
        new Q_2().solution("12223");
    }

    public int solution(String s) {
        List<String> strs = new ArrayList<>();
        int count = 0;
        char prior = 'a';
        for (char c: s.toCharArray()) {
            if (c != prior) {
                count = 1;
                prior = c;
                continue;
            } else {
                count++;
            }
            if (count == 3) {
                count = 1;
                strs.add("" + c + c + c);
            }

        }

        if (strs.isEmpty()) return -1;

        List<Integer> answers = strs.stream().map(Integer::valueOf).collect(Collectors.toList());
        answers.sort(Collections.reverseOrder());
        return answers.get(0);
    }

}
