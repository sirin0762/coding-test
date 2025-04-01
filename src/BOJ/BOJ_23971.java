package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_23971 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int height = inputs[0];
        int width = inputs[1];
        int hLimit = inputs[2];
        int wLimit = inputs[3];

        int x = (width - 1) / (wLimit + 1) + 1;
        int y = (height - 1) / (hLimit + 1)  + 1;
        System.out.println(x * y);

    }

}
