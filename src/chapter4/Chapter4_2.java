package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter4_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;
        int row = input.charAt(0) - 'a';
        int col = input.charAt(1) - '1';

        int[][] directions = new int[][]{
            {-1, 2}, {1, 2}, {2, 1}, {2, -1},
            {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}
        };

        for (int i = 0; i < directions.length; i++) {
            if (row + directions[i][0] >= 0 && row + directions[i][0] <= 7 &&
                col + directions[i][1] >= 0 && col + directions[i][1] <= 7
            ) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
