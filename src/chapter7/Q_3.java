package chapter7;

import java.util.Arrays;

public class Q_3 {

    // 1. h번 이상 인용된 논문이 h편 이상
    // 1. 논문을 오름차순으로 정렬
    // 2. 주어진 논문을 순회하며 h-index 계산
    // 3. h index가 안나오면 종료
    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 1; i < citations[citations.length - 1]; i++) {
            if (i <= getCitationSameOrUpperCount(i, citations)) {
                answer = i;
            } else {
                break;
            }
        }
        return answer;
    }

    private int getCitationSameOrUpperCount(int citation, int[] citations) {
        return (int) Arrays.stream(citations).filter(c -> c >= citation).count();
    }

}
