package chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q_5_RETRY {

    public static void main(String[] args) {
        Q_5_RETRY main = new Q_5_RETRY();
        main.solution(
            new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[] {"fr*d*", "*rodo", "******", "******"}
        );
    }

    public int solution(String[] user_id, String[] banned_id) {
        banned_id = Arrays.stream(banned_id).map(id -> id.replace("*", ".")).toArray(String[]::new);
        String[][] bans = new String[banned_id.length][];
        for (int i = 0; i < banned_id.length; i++) {
            String banId = banned_id[i];
            bans[i] = Arrays.stream(user_id).filter(id -> id.matches(banId)).toArray(String[]::new);
        }

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

}
