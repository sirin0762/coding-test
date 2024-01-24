package chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class BOJ1082_RETRY {

    private static int remind = 0;
    private static int minIndex = 0;


    // 1. 가장 작은 금액의 숫자를 찾아서 해당 수로 가장 긴 크기의 문자열을 만든다.
        // 1-1. 만약 그게 0이라면, 두번째로 큰 숫자를 앞에 두고 나머지는 0으로 뒤덮는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] p = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());

        String minimumStr = getMinimumString(p, m);
        StringBuilder sb = new StringBuilder(minimumStr);
        int strIndex = 0;
        while (true) {
            if (strIndex >= sb.length()) break;
            int[] max = getMaxValue(p, sb.charAt(strIndex) - '0');
            if (Objects.isNull(max)) break;
            sb.setCharAt(strIndex, (char) (max[0] + '0'));
            strIndex++;
        }
        System.out.println(sb);
    }

    private static int[] getMaxValue(String[] p, int strIndex) {
        for (int i = p.length - 1; i >= 0; i--) {
            int max = Integer.parseInt(p[i]);
            int min = Integer.parseInt(p[strIndex]);
            if (remind + min >= max) {
                remind = remind + min - max;
                return new int[] {i, max};
            }
        }
        return null;
    }

    private static String getMinimumString(String[] p, int m) {
        int minValueIndex = getMinValueNum(p);
        int minValue = Integer.parseInt(p[minValueIndex]);

        if (minValueIndex == 0) {
            return getMinimumStringWithZero(minValueIndex, m, p);
        } else {
            return getMinimumString(minValueIndex, minValue, m);
        }
    }

    private static String getMinimumString(int minValueIndex, int minValue, int m) {
        StringBuilder result = new StringBuilder();
        while (m >= minValue) {
            result.append(minValueIndex);
            m -= minValue;
        }
        remind = m;
        return result.toString();
    }

    private static String getMinimumStringWithZero(int minValueIndex, int m, String[] p) {
        int secondIndex = getSecondIndex(minValueIndex, p);
        StringBuilder result = new StringBuilder(String.valueOf(secondIndex));
        m -= Integer.parseInt(p[secondIndex]);

        int minValue = Integer.parseInt(p[minValueIndex]);
        while (m >= minValue) {
            result.append(minValueIndex);
            m -= minValue;
        }
        remind = m;
        return result.toString();
    }

    private static int getSecondIndex(int minValueIndex, String[] p) {
        int minValue = Integer.parseInt(p[minValueIndex]);
        int secondIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < p.length; i++) {
            if (Integer.parseInt(p[i]) > minValue && Integer.parseInt(p[i]) <= min) {
                secondIndex = i;
                min = Integer.parseInt(p[i]);
            }
        }
        return secondIndex;
    }

    private static int getMinValueNum(String[] p) {
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = 0;
        for (int i = 0; i < p.length; i++) {
            if (minValue >= Integer.parseInt(p[i])) {
                minValueIndex = i;
                minValue = Integer.parseInt(p[i]);
            }
        }
        minIndex = minValueIndex;
        return minValueIndex;
    }

}
