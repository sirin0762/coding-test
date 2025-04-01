package toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Problem_3 {

    public static void main(String[] args) {
        Problem_3 solution = new Problem_3();
        System.out.println(solution.solution(3, new String[]{"1", "3", "2", "B", "4", "F"}));
    }

    public String[] solution(int maxSize, String[] actions) {
        Stack<String> goBack = new Stack<>();
        Stack<String> goFront = new Stack<>();
        ArrayList<String> goRecently = new ArrayList<>();

        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];
            if (action == "B") {
                if (goBack.isEmpty()) continue;
                String now = goBack.pop();
                goFront.add(goRecently.get(goRecently.size() - 1));
                goRecently.remove(now);
                goRecently.add(now);
                if (goRecently.size() > maxSize) goRecently.remove(0);
            }
            else if (Objects.equals(action, "F")) {
                if (goFront.isEmpty()) continue;
                String now = goFront.pop();
                goBack.add(goRecently.get(goRecently.size() - 1));
                goRecently.remove(now);
                goRecently.add(now);
                if (goRecently.size() > maxSize) goRecently.remove(0);
            }
            else {
                // 최근 방문 목록 이동
                if (goRecently.size() != 0) {
                    goBack.add(goRecently.get(goRecently.size() - 1));
                }
                goRecently.remove(action);
                goRecently.add(action);
                if (goRecently.size() > maxSize) goRecently.remove(0);
                goFront.empty();
            }
        }
        Collections.reverse(goRecently);
        System.out.println(Arrays.toString(goRecently.toArray(new String[0])));
        return goRecently.toArray(new String[0]);
    }



}
