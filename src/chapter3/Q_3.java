package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Q_3 {

    // 1. 주어진 대기실을 순회한다.
    // 2. 순회하다가 응시자를 만나면, 해당 응시자를 기준으로 다른 응시자의 접근 유무를 확인한다.
    // 3. 접근하지 않으면, 거리두기 유무를 확인한다.

    public static void main(String[] args) {
        Q_3 q3 = new Q_3();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        q3.solution(places);

    }

    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        for(String[] p: places) {
            char[][] place = convertStringArrToCharArr(p);
            if (checkPos(place)) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }
        return answer.stream().mapToInt(i -> (int) i).toArray();
    }

    private boolean checkPos(char[][] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length; j++) {
                if (place[i][j] == 'P') {
                    return validate(place, i, j);
                }
            }
        }
        return true;
    }

    private boolean validate(char[][] place, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= place[0].length || ny >= place.length) continue;

            if (place[ny][nx] == 'P') return false;
            if (place[ny][nx] == 'O') return checkNextPos(place, nx, ny, x, y);
        }
        return true;
    }

    private boolean checkNextPos(char[][] place, int x, int y, int px, int py) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= place[0].length || ny >= place.length) continue;

            if (place[ny][nx] == 'P' && nx != px && ny != py) return false;
        }
        return true;
    }

    private char[][] convertStringArrToCharArr(String[] p) {
        char[][] result = new char[p.length][p[0].length()];
        for (int i = 0; i < p.length; i++) {
            result[i] = p[i].toCharArray();
        }
        return result;
    }

}
