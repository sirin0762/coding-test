package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_3 {

    // 1. 주어진 연산자를 이용하여 연산자에 대한 순열조건을 만들어야한다.
    // 2. 순열 조건을 만족하면 해당 우선 순위에 대하여 계산을 진행한다.
        // 2.1 계산을 진행하기 앞서 숫자와 부호로 나뉜 배열을 반환한다.
        // 2.2 해당 배열을 순회하며 계산을 진행한다.

    private static char[] operands = new char[]{'*', '+', '-'};
    private static boolean[] visited = new boolean[3];
    private long answer = Long.MIN_VALUE;

    public static void main(String[] args) {
        Q_3 q3 = new Q_3();
        q3.solution("100-200*300-500+20");
    }

    public long solution(String expression) {
        dfs(0, new char[3], expression);

        return answer;
    }

    private void dfs(int depth, char[] chars, String expression) {
        if (depth == 3) {
            calculate(chars, expression);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                chars[depth] = operands[i];
                dfs(depth + 1, chars, expression);
                visited[i] = false;
            }
        }
    }

    private void calculate(char[] chars, String expression) {
        List<String> splits = new ArrayList<>(Arrays.asList(expression.split("((?=[+*-])|(?<=[+*-]))")));
        for (char c: chars) {
            for (int i = 0; i < splits.size(); i++) {
                String str = splits.get(i);
                if (str.length() == 1 && str.charAt(0) == c) {
                    String lhs = splits.get(i - 1);
                    String lrs = splits.get(i + 1);
                    splits.remove(i - 1);
                    splits.remove(i - 1);
                    splits.remove(i - 1);
                    splits.add(i - 1, calculate(lhs, lrs, c));
                    i -= 2;
                }
            }
        }
        answer = Math.max(answer, Math.abs(Long.parseLong(splits.get(0))));
    }

    private String calculate(String str1, String str2, char c) {
        long oper1 = Long.parseLong(str1);
        long oper2 = Long.parseLong(str2);
        if (c == '+') {
            return String.valueOf(oper1 + oper2);
        }
        if (c == '*') {
            return String.valueOf(oper1 * oper2);
        }
        return String.valueOf(oper1 - oper2);
    }

}
