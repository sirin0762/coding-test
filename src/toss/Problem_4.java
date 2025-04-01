package toss;

import java.util.ArrayList;

public class Problem_4 {

    public boolean[][] chipMap;

    public static void main(String[] args) {
        Problem_4 solution = new Problem_4();
        System.out.println(solution.solution(10, 10, 3, 2, 7,
            new int[][]{{2, 2}, {2, 3}, {2, 4}, {6, 2}, {6, 3}, {6, 4}, {3, 5}}));
    }

    public int solution(int A, int B, int C, int D, int N, int[][] Chips) {
        // 케이크: A cm x B cm
        // 직사각형 틀: C cm x D cm
        // 초콜릿 칩: N개
        // 초콜릿 칩의 좌표 xn, yn: (Chips[nMjlOOX-1][0], Chips[n-1][1])
        int answer = 0;
        chipMap = new boolean[A + 1][B + 1];

        for (int i = 0; i < N; i++) {
            int x = Chips[i][0];
            int y = Chips[i][1];
            chipMap[x][y] = true;
        }

        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                answer = Math.max(answer, getChipCount(i, j, A, B, C, D));
            }
        }

        return answer;
    }

    private int getChipCount(int x, int y, int A, int B, int C, int D) {
        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i <= C; i++) {
            for (int j = 0; j <= D; j++) {
                if (x + i < 1 ||  x + i > A || y + j < 1 || y + j > B) continue;
                if (chipMap[x + i][y + j]) result1++;
            }
        }

        for (int i = 0; i <= D; i++) {
            for (int j = 0; j <= C; j++) {
                if (x + i < 1 ||  x + i > A || y + j < 1 || y + j > B) continue;
                if (chipMap[x + i][y + j]) result2++;
            }
        }

        return Math.max(result1, result2);
    }

}
