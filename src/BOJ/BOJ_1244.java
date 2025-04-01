package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
public class BOJ_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] switches = new int[n + 1]; // 1-based index

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());

        for (int s = 0; s < students; s++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                // 남학생: 배수 토글
                for (int i = number; i <= n; i += number) {
                    switches[i] = switches[i] ^ 1;
                }
            } else {
                // 여학생: 대칭 토글
                int left = number;
                int right = number;

                while (left >= 1 && right <= n && switches[left] == switches[right]) {
                    left--;
                    right++;
                }

                // 마지막 while에서 한 칸 더 나가므로 복원
                left++;
                right--;

                for (int i = left; i <= right; i++) {
                    switches[i] = switches[i] ^ 1;
                }
            }
        }

        // 출력: 20개씩 줄바꿈
        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    static class Student {
        private int gender;
        private int target;

        public Student(int gender, int target) {
            this.gender = gender;
            this.target = target;
        }

        public int getGender() {
            return gender;
        }

        public int getTarget() {
            return target;
        }

        public boolean isMale() {
            return gender == 1;
        }

    }

}
