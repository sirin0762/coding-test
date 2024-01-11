package chapter4;

public class Q_2_RETRY {

    public static void main(String[] args) {
        Q_2_RETRY main = new Q_2_RETRY();
        System.out.println(main.solution("ZB", 1));
    }

    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!Character.isWhitespace(c)) {
                c = push(arr[i], n);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private char push(char c, int n) {
        char offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % 26;
        return (char) (position + offset);
    }

}
