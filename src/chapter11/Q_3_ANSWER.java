package chapter11;

import java.util.Stack;

public class Q_3_ANSWER {

    // 1. 스택에 각 배열의 인덱스를 넣는다.
    // 2. stack을 계속 순회하며, stack.peek값이 price 값 보다 크다면, 해당 i - index를 answer에 넣어준다.
    // 3. 해당 과정이 끝나도 stack 내부에 앖이 있다면, 해당 원소들은 내려간적이 없지 떄문에 price.lenght - index - 1을 넣어준다.

    public static void main(String[] args) {

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            // 중요 : 스택순회방법
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }

}
