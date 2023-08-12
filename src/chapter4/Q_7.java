package chapter4;

public class Q_7 {

    public static void main(String[] args) {

    }

    boolean solution(String s) {
        s = s.toUpperCase();
        int sp = s.length() - s.replaceAll("P", "").length();
        int sy = s.length() - s.replaceAll("Y", "").length();

        return sp == sy;
    }

}
