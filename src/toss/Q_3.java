package toss;

public class Q_3 {

    public static void main(String[] args) {
        System.out.println(new Q_3().solution("0+"));
    }

    public boolean solution(String amountText) {
        if (amountText.matches(".*[^0-9,].*")) return false;
        if (amountText.charAt(0) == '0' && amountText.length() != 1) return false;
        if (amountText.matches("^[0-9]+$")) return true;
        if (isRightSeperator(amountText) && !amountText.startsWith(",") && !amountText.endsWith(",")) return true;
        return false;
    }

    private boolean isRightSeperator(String amountText) {
        int count = 0;
        for (int i = amountText.length() - 1; i >= 0; i--) {
            char c = amountText.charAt(i);
            if (Character.isDigit(c)) count++;
            else {
                if (count % 3 != 0) return false;
            }
        }
        return true;
    }

}
