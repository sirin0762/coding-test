package chapter6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q_5 {

    // 1. Banned_id 를 순회한다.
    // 2. user_id를 순회하며 매핑되는 것을 찾는다.
    // 3. 해당 값을 모두 곱한다.

    public static void main(String[] args) {
        Q_5 q5 = new Q_5();
        q5.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        Map<String, Duplicate> map = new HashMap<>();

        for (String id : banned_id) {
            if (map.containsKey(id)) {
                map.put(id, new Duplicate(map.get(id).duplicatedCount + 1, map.get(id).count + getBannedIdCandidate(id, user_id)));
            } else {
                map.put(id, new Duplicate(1, getBannedIdCandidate(id, user_id)));
            }
        }

        for (Duplicate v : map.values()) {
            answer *= v.count / Math.pow(2, v.duplicatedCount);
        }
        return answer;
    }

    private int getBannedIdCandidate(String bannedId, String[] userIds) {
        int result = 0;
        for (String userId : userIds) {
            if (bannedId.length() != userId.length()) continue;
            if (isCandidate(userId, bannedId)) result++;
        }
        return result;
    }

    private boolean isCandidate(String userId, String bannedId) {
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (bannedId.charAt(i) != userId.charAt(i)) return false;
        }
        return true;
    }

    static class Duplicate {
        int duplicatedCount;
        int count;

        public Duplicate(int duplicatedCount, int count) {
            this.duplicatedCount = duplicatedCount;
            this.count = count;
        }

    }

}
