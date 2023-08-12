package chapter4;

public class Q_10 {

    public static void main(String[] args) {
        Q_10 q10 = new Q_10();
        System.out.println(q10.solution("=.="));
    }

    public String solution(String new_id) {
        // step 1
        new_id = new_id.toLowerCase();

        // step 2
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");

        // step 3
        new_id = new_id.replaceAll("[.]{2,}", ".");

        // step 4
        new_id = new_id.replaceAll("^[.]", "").replaceAll("[.]$", "");

        // step 5
        if (new_id.isBlank()) new_id = "a";

        // step 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        // step 7
        if (new_id.length() <= 2) {
            StringBuilder sb = new StringBuilder(new_id);
            char lastChar = new_id.charAt(new_id.length() - 1);
            while (sb.length() != 3) {
                sb.append(lastChar);
            }
            new_id = sb.toString();
        }

        return new_id;
    }

}
