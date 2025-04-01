package toss;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1451232125", 2));
    }

    public int solution(String s, int N) {
        if (N == 0) {
            return -1;
        }
        int answer = -1;
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = String.valueOf(i + 1);
        }

        for (int i = 0; i < s.length() - N; i++) {
            String str = s.substring(i, i + N);
            if (!isPenDigital(str, arr)) continue;
            answer = Math.max(answer, Integer.parseInt(str));
        }
        return answer == 0 ? -1 : answer;
    }

    private boolean isPenDigital(String str, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!str.contains(arr[i])) return false;
        }
        return true;
    }

}
