package chapter11;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Q_3_RETRY {

    public static void main(String[] args) {
        Q_3_RETRY main = new Q_3_RETRY();
        System.out.println(main.solution(new int[][]{
            {-20,-15}, {-14,-5},{-18,-1},{-5,-3}
        }));
    }

    // 1. 주어진 루트의 맨 끝을 기준으로 정렬
    // 2. 좌측에서 부터 기준을 두고, 해당 기준에 충족하지 않으면 카메라 개수를 늘리고 기준을 해당 끝점으로,
    // 3. 이걸 반복
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int pos = Integer.MIN_VALUE;
        int answer = 0;
        for (int[] route: routes) {
            if (route[0] > pos) {
                answer++;
                pos = route[1];
            }
        }
        return answer;
    }

}
