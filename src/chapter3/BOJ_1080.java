package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1080 {

    private static int n;
    private static int m;

    private static char[][] arr1;
    private static char[][] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr1 = new char[n][m];
        arr2 = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr1[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int y = 0; y <= n - 3; y++) {
            for (int x = 0; x <= m - 3; x++) {
                if (arr1[y][x] == arr2[y][x]) continue;
                reverseArray(x, y);
                answer++;
            }
        }

        if (isSame()) System.out.println(answer);
        else System.out.println(-1);
    }

    private static boolean isSame() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }

    private static void reverseArray(int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr1[y + i][x + j] == '1')  arr1[y + i][x + j] = '0';
                else arr1[y + i][x + j] = '1';
            }
        }
    }

}
