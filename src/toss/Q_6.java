package toss;

import java.util.Arrays;

public class Q_6 {

    public static void main(String[] args) {

    }

    public long solution(int money, long[][] stocks) {
        Arrays.sort(stocks, (s1, s2) -> (int) ((s2[1] - s2[0]) - (s1[1] - s1[0])));
        long answer = 0;
        for (int i = 0; i < stocks.length; i++) {
            if (money < stocks[i][1]) break;

            money = (int) (money - stocks[i][1]);
            answer += stocks[i][0];
        }
        return answer;
    }

}
