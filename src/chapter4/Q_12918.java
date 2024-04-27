package chapter4;

public class Q_12918 {

    public static void main(String[] args) {
        new Q_12918().solution("1234");
    }

    public boolean solution(String s) {
        return s.matches("[0-9]{4,6}");
    }

}
