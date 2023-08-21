package chapter8;

public class Q_2 {

    public static void main(String[] args) {

    }

    public long solution(int n, int[] times) {
        long start = 0L;
        long end = 1_000_000_000L * 1_000_000_000L;

        while (start < end) {
            long mid = (start + end) / 2;
            long possibleCount = getPossibleCount(mid, times);
            if (n <= possibleCount) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private long getPossibleCount(long mid, int[] times) {
        long result = 0;
        for (int time : times) {
            result += (mid / time);
        }
        return result;
    }

}
