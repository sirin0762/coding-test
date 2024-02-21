package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BOJ1041 {

    // n이 1 -> 6개의 경우의 수 중에 가장 작은 것
    // n이 2 -> 마주보는 2개의 면 중에 최솟값 & 마주보는 3개의 면 중에 최솟값
    // n이 3이상이면 -> 최소면 1개 + 최소면 2개 + 최소면 3개

    static List<String> twoPlane = List.of("AB", "AC", "AD", "AE", "BC", "BD", "BF", "CE", "CF", "DE", "DF", "EF");
    static List<String> threePlane = List.of("ABC", "ACE", "AED", "ADB", "BCF", "BDF", "CEF", "DEF");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        long min1 = getMinNum(numbers);
        long min2 = getMin2Num(numbers);
        long min3 = getMin3Num(numbers);
        if (n == 1) {
            System.out.println(IntStream.of(numbers).sum() - min1);
        }
        else {
            long threePlanes = min3 * 4L;
            long twoPlanes = min2 * (8L * n - 12);
            long onePlane = 4 * min1 * (n - 2) * (n - 1) + min1 * (n - 2) * (n - 2);
            System.out.println(threePlanes + twoPlanes + onePlane);
        }
    }

    private static long getMin3Num(int[] numbers) {
        long min = Long.MAX_VALUE;
        for (String str: threePlane) {
            long result = 0;
            for (char c: str.toCharArray()) {
                int index = c - 'A';
                result += numbers[index];
            }
            min = Long.min(min, result);
        }
        return min;
    }

    private static long getMin2Num(int[] numbers) {
        long min = Integer.MAX_VALUE;
        for (String str: twoPlane) {
            long result = 0;
            for (char c: str.toCharArray()) {
                int index = c - 'A';
                result += numbers[index];
            }
            min = Long.min(min, result);
        }
        return min;
    }

    private static long getMinNum(int[] numbers) {
        long min = Long.MAX_VALUE;
        for (int n: numbers) {
            min = Long.min(min, n);
        }
        return min;
    }

}
