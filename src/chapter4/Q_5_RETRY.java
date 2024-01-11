package chapter4;

public class Q_5_RETRY {

    public static void main(String[] args) {
        Q_5_RETRY main = new Q_5_RETRY();
        System.out.println(main.solution(45));
    }

    public int solution(int n) {
        String reversedTri = new StringBuilder(Integer.toString(n, 3)).reverse().toString();
        return Integer.valueOf(reversedTri, 3);
    }

}
