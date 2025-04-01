package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2529 {

    public static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    public static boolean[] visited = new boolean[10];
    public static String[] signs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        signs = br.readLine().split(" ");
        dfs();
    }

    private static void dfs() {

    }

}
