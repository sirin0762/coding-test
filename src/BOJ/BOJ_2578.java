package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 빙고
public class BOJ_2578 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Node> board = new HashMap<Integer, Node>();
        int[][] bingo = new int[5][5];
        boolean[][] isDeleted = new boolean[5][5];
        StringTokenizer st;

        // 빙고 생성
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                bingo[i][j] = number;
                board.put(number, new Node(i, j));
            }
        }

        // 정답 확인
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answers.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < answers.size(); i++) {
            int answer = answers.get(i);
            Node targetNode = board.get(answer);
            isDeleted[targetNode.x][targetNode.y] = true;
            if (checkBingo(isDeleted)) {
                System.out.println(i + 1);
                break;
            };
        }
    }

    private static boolean checkBingo(boolean[][] isDeleted) {
        int count = 0;
        count += countVerticalBingo(isDeleted);
        count += countHorizontalBingo(isDeleted);
        count += countDiagonalBingo(isDeleted);
        return count >= 3;
    }

    private static int countDiagonalBingo(boolean[][] isDeleted) {
        int count = 0;
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!isDeleted[i][i]) {
                isBingo = false;
            }
        }

        if (isBingo) {
            count++;
        }

        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!isDeleted[4 - i][i]) {
                isBingo = false;
            }
        }
        if (isBingo) {
            count++;
        }

        return count;
    }

    private static int countHorizontalBingo(boolean[][] isDeleted) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!isDeleted[i][j]) {
                    isBingo = false;
                }
            }

            if (isBingo) {
                count++;
            }
        }
        return count;
    }

    private static int countVerticalBingo(boolean[][] isDeleted) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!isDeleted[j][i]) {
                    isBingo = false;
                }
            }

            if (isBingo) {
                count++;
            }
        }
        return count;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
