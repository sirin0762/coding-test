package chapter11;

import java.util.Map;
import java.util.Stack;

public class Q_2 {

    // 1. 주어진 문자열을 왼쪽으로 회전 시킨다.
    // 2. 해당 문자열이 올바른 문자열인지 확인한다.
        // 2.1 Stack을 통해
            // 1) 입구인 경우 : stack.push
            // 2) 출구인 경우 : stack.pop & 비교

    public static void main(String[] args) {

    }

    public int solution(String s) {
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            sb.append(s, i, s.length()).append(s, 0, i);

            if (isCollectString(map, stack, sb)) answer++;
        }
        return answer;
    }

    private static boolean isCollectString(Map<Character, Character> map, Stack<Character> stack, StringBuilder sb) {
        for (char c : sb.toString().toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }

}
