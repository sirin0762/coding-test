package chapter11;

import java.util.Stack;

public class Q_1_RETRY {

    public static void main(String[] args) {
        Q_1_RETRY main = new Q_1_RETRY();
        System.out.println(main.solution("{}{}"));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c: chars) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                if (stack.pop() == ')') return false;
            }
        }
        return stack.isEmpty();
    }

}
