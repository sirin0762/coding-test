package chapter8;

public class Q_2_RETRY {

    public static void main(String[] args) {

    }

    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1_000_000_000L * 1_000_000_000L;

        while (start < end) {
            long mid = (start + end) / 2;
            long possibleCount = getPossibleCount(mid, times);
            if (possibleCount >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private long getPossibleCount(long time, int[] times) {
        long result = 0L;
        for (int i = 0; i < times.length; i++) {
            result += time / times[i];
        }
        return result;
    }

}
