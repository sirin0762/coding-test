package chapter7;

import java.util.Arrays;
import java.util.Comparator;

public class Q_5_RETRY {

    public static void main(String[] args) {
        Q_5_RETRY main = new Q_5_RETRY();
        System.out.println(Arrays.toString(main.solution(new String[] {"sun", "bed", "car"}, 1)));
    }

    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted(
            (s1, s2) -> {
                if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        ).toArray(String[]::new);
    }

}
