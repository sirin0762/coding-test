package chapter7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Q_6 {

    // 1. 주어진 정수를 문자열로 바꾼다.
    // 2.

    public static void main(String[] args) {
        System.out.println("9".compareTo("10"));
    }

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> {
                int original = Integer.parseInt(s1 + s2);
                int reversed = Integer.parseInt(s2 + s1);
                return reversed - original;
            })
            .collect(Collectors.joining(""))
            .replaceAll("^0+", "0");
    }

}
