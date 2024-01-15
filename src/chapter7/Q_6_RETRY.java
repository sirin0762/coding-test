package chapter7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Q_6_RETRY {

    public static void main(String[] args) {
        Q_6_RETRY main = new Q_6_RETRY();
//        System.out.println("3".compareTo("3"));
        System.out.println(main.solution(new int[] {3, 30, 34, 5, 9}));
    }

    public String solution(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).sorted(
            (s1, s2) -> {
                int ordinal = Integer.parseInt(s1 + s2);
                int reverse = Integer.parseInt(s2 + s1);
                return reverse - ordinal;
            })
            .collect(Collectors.joining(""))
            .replaceAll("^0+", "0");
    }

}
