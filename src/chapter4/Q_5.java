package chapter4;

public class Q_5 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        String ternary = Integer.toString(n, 3);
        String reversedTernary = new StringBuilder(ternary).reverse().toString();
        return Integer.parseInt(reversedTernary, 3);
    }

}
