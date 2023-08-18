package chapter7;

import java.util.Arrays;

public class Q_4 {

    public static void main(String[] args) {

    }

    public String solution(String s) {
        return s.chars()
            .boxed()
            .sorted((c1, c2) -> c2 - c1)
            .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
            )
            .toString();

    }

}
