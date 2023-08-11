package chapter4;

public class Q_6 {

    public static void main(String[] args) {

    }

    public int[] solution(String s) {
        int count = 0;
        int removedZero = 0;
        while (true) {
            if (s.equals("1")) break;
            TranslateResult result = translateBinary(s);
            s = result.resultString;
            removedZero += result.removedZero;
            count++;
        }
        return new int[] {count, removedZero};
    }

    private TranslateResult translateBinary(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '0') result++;
            else sb.append(c);
        }

        return new TranslateResult(Integer.toString(sb.toString().length(), 2), result);
    }

    private static class TranslateResult {

        private String resultString;
        private int removedZero;

        public TranslateResult(String resultString, int removedZero) {
            this.resultString = resultString;
            this.removedZero = removedZero;
        }

    }

}
