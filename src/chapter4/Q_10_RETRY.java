package chapter4;

public class Q_10_RETRY {

    public static void main(String[] args) {
        Q_10_RETRY main = new Q_10_RETRY();
        System.out.println(main.solution("123_.def"));
    }

    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        if (new_id.isEmpty()) new_id = "a";
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
        if (new_id.length() <= 2) new_id = new_id + String.valueOf(new_id.charAt(new_id.length() - 1)).repeat((3 - new_id.length()));
        return new_id;
    }

}
