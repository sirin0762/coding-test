package chapter4;

public class Q_3_RETRY {

    public static void main(String[] args) {
        Q_3_RETRY main = new Q_3_RETRY();
        System.out.println(main.solution("try hello world"));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (Character.isWhitespace(c)) {
                index = 0;
            }
            else if (index % 2 == 0) {
                c = Character.toUpperCase(c);
                index++;
            } else {
                c = Character.toLowerCase(c);
                index++;
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
