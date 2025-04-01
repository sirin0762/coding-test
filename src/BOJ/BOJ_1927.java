package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command >= 1) {
                pq.add(command);
            } else {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(String.valueOf(pq.poll()) + '\n');
                }
            }
        }
        bw.flush();
        bw.close();
    }

}
