package chapter11;

import java.util.Arrays;

public class Q_2_RETRY {

    public static void main(String[] args) {
        Q_2_RETRY main = new Q_2_RETRY();
        System.out.println(Arrays.toString(main.solution(new int[]{1, 2, 3, 2, 3})));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) count++;
                else break;
            }
            if (count == prices.length - i) count--;
            answer[i] = count;
        }
        answer[answer.length - 1] = 0;
        return answer;
    }

}
