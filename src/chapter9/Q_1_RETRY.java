package chapter9;

public class Q_1_RETRY {

    public static void main(String[] args) {
        Q_1_RETRY main = new Q_1_RETRY();
        main.solution(new int[][] {
            {1, 4},{9, 2},{3, 8},{11, 6}
        });
    }
    // 주어진 점 4개에서 평행 유무판단
    // 점 4개에 대한 순서로 확인
    public int solution(int[][] dots) {
        if (count(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (count(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (count(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }

    private boolean count(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        double a1 = getLine(dot1, dot2);
        double a2 = getLine(dot3, dot4);
        return a1 == a2;
    }

    private double getLine(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }

}
