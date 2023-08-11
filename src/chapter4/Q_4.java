package chapter4;

public class Q_4 {

    // 1, 주어진 문자열을 길이대로 자른다.
    // 2. 해당 길이를 target으로 삼고 순회한다.
        // 2.1 target과 같은 문자열이라면, count를 올려준다.
        // 2.1 target과 다른 문자열이라면, target을 변경해준다.
    // 3. target이 변경될 떄 sb에 insert를 해준다.
        // 3.1 target의 count 가 1 이라면 그냥 해당 target을 insert한다.
        // 3.2 target의 count 가 > 1 이라면 count + target을 insert한다.
    // 4. 순회가 끝나면 다음과 같다.
        // 4.1 count가 1 이상인 경우 : 아직 sb에 insert가 안되었다.

    public static void main(String[] args) {
        Q_4 q4 = new Q_4();
        System.out.println(q4.solution("aabbaccc"));
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int maxLength = Integer.max(1, s.length() / 2);

        for (int length = 1; length <= maxLength; length++) {
            int begin = 0;
            int end = length;
            int count = 1;
            String target = s.substring(begin, end);
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (end > s.length()) break;

                String other = end + length > s.length() ? s.substring(begin + length) : s.substring(begin + length, end + length);

                if (target.equals(other)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(target);
                    count = 1;
                    target = other;
                }
                begin = end;
                end += length;
            }
            if (count > 1) {
                sb.append(count);
                sb.append(target);
            } else {
                sb.append(s.substring(begin));
            }
            System.out.println(sb);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

}
