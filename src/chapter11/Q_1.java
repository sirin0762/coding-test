package chapter11;

import java.util.Stack;

public class Q_1 {

    // 1. 문자열을 순회한다.
        // 1.1 '(' 인 경우, Stack에 넣는다.
        // 1.2 ')' 인 경우, Stack에서 꺼내 '('이 있는지 확인한다.

    public static void main(String[] args) {

    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.add(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
