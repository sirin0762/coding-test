package chapter11;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Q_2_RETRY_2 {

    public static void main(String[] args) {
        Q_2_RETRY_2 main = new Q_2_RETRY_2();
        main.solution("4177252841", 4);
    }

    // 1. 앞부터 전진하였을 때, 뒤의 수가 더 크면 앞의 수를 없애면 해결
    // 2. 주어진 수를 하나씩 stack에 넣고, 그 뒤에수가 더 크면 pop 하면서 제거
    // 3. 이걸 k까지 반복
    // 4. k가 0보다 크다면 0까지 pop
    public String solution(String number, int k) {
        int[] nums = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            // stack이 비어있으면 로직 없이 넣어준다.
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i] && k > 0){
                stack.pop();
                k--;
            }

            stack.push(nums[i]);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }



}
