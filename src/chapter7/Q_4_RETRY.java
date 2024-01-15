package chapter7;

import java.util.Arrays;
import java.util.Comparator;

public class Q_4_RETRY {

    public static void main(String[] args) {
        Q_4_RETRY main = new Q_4_RETRY();
        System.out.println(main.solution("Zbcdefg"));
    }

    public String solution(String s) {
        String[] reversed = Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        return String.join("", reversed);
    }

}
