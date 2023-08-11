package chapter4;

public class Q_2 {

    public static void main(String[] args) {
        System.out.println('Z' - 'A');
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            sb.append(push(c, n));
        }
        return sb.toString();
    }

    private char push(char c, int n) {
        if (Character.isWhitespace(c)) return c;

        char offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (position + offset);
    }

}
