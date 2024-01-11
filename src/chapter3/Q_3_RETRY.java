package chapter3;

import java.util.Arrays;

public class Q_3_RETRY {

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Q_3_RETRY main = new Q_3_RETRY();
        int[] solution = main.solution(new String[][]{
            {"POOOP", "OXXOX", "OXXPX", "OPXOX", "PXXXP"}
        });
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            if (checkDistance(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean checkDistance(String[] place) {
        char[][] map = new char[place.length][place.length];
        for (int i = 0; i < place.length; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place.length; j++) {
                if (map[i][j] == 'P' && !checkDistance(map, i, j)) return false;
            }
        }

        return true;
    }

    private boolean checkDistance(char[][] map, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny >= map.length || ny < 0 || nx >= map[ny].length) continue;

            if (map[nx][ny] == 'P') return false;
            if (map[nx][ny] == 'O') return checkNext(map, nx, ny, x, y);
        }
        return true;
    }

    private boolean checkNext(char[][] map, int x, int y, int humanX, int humanY) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny >= map.length || ny < 0 || nx >= map[ny].length ) continue;

            if (nx == humanX && ny == humanY) continue;

            if (map[nx][ny] == 'P') return false;
        }
        return true;
    }


}
