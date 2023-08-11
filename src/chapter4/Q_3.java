package chapter4;

public class Q_3 {

    // 1. 주어진 char[] 을 순회한다.
    // 2. 다음 로직을 따른다.
        // 2.1 - 공백인 경우, 홀짝을 담당하는 변수를 0으로 초기화 한다.
        // 2.2 - 공백이 아닌 경우, 홀짝을 담당하는 변수를 1 올리며, 짝 홀 로직을 태운다.
    // 3. 이 과정을 순회하며 StringBuilder 에 쌓는다.

    public static void main(String[] args) {

    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        for (char c: s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                sb.append(c);
                pos = 0;
            } else {
                if (pos % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                pos++;
            }
        }
        return sb.toString();
    }

}
