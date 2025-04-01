//package practive;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class BOJ_21608 {
//
//    public static int[][] seats;
//    public static int[] students;
//    public static final int INF = (int) 1e9;
//    public static int n;
//    public static Map<Integer, Set<Integer>> preference = new HashMap<>();
//
//    public static int[] dx = {-1, 1, 0, 0};
//    public static int[] dy = {0, 0, -1, 1};
//
//    public static void main(String[] args) throws IOException {
//        init();
//
//        solution();
//    }
//
//    private static void solution() {
//        for (int i = 0; i < students.length; i++) {
//            Seat seat = findSeat(students[i]);
//            seats[seat.x][seat.y] = students[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int count = getStudnetSum(i, j, seats[i][j]);
//                if (count > 0) {
//                    sum += (int) Math.pow(10, count - 1);
//                }
//            }
//        }
//    }
//
//    private static void init() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n * n; i++) {
//            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int student = input[0];
//            students[i] = student;
//            preference.put(student, new HashSet<>());
//            for (int j = 1; i < 5; i++) {
//                preference.get(student).add(input[j]);
//            }
//        }
//
//    }
//
//}
//
//class Seat implements Comparable<Seat> {
//
//    public int x;
//    public int y;
//    public int studentSum;
//    public int emptySum;
//
//    public Seat(int x, int y, int studentSum, int emptySUm) {
//        this.x = x;
//        this.y = y;
//        this.studentSum = studentSum;
//        this.emptySum = emptySUm;
//    }
//
//    @Override
//    public int compareTo(Seat other) {
//        if (this.studentSum != other.studentSum) return other.studentSum - this.studentSum;
//
//        if (this.emptySum != other.emptySum) return other.emptySum - this.emptySum;
//
//        if (this.x != other.x) return this.x - other.x;
//
//        return this.y - other.y;
//    }
//
//}
