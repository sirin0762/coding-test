package chapter3;

public class Q_4 {

    private int m;
    private int n;
    private int k;

    public static void main(String[] args) {

    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        m = arr1.length;
        n = arr2[0].length;
        k = arr2.length;

        int[][] answer = new int[m][n];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                answer[y][x] = getElement(arr1, arr2, x, y);
            }
        }

        return answer;
    }

    private int getElement(int[][] arr1, int[][] arr2, int x, int y) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += arr1[y][i] * arr2[i][x];
        }
        return result;
    }

}
