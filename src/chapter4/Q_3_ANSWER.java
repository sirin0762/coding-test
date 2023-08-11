package chapter4;

public class Q_3_ANSWER {

    public static void main(String[] args) {

    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;

        for (char c: s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                sb.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return sb.toString();
    }

}
