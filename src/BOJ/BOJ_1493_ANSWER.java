package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1493_ANSWER {

    static int [] cube=new int[20]; //큐브의 개수
    static int count= 0;  // 박스안에 들어갈 큐브를 카운트하는 변수
    static boolean state = true; //박스안에 큐브가 들어가는지 판단하는 bool 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            cube[t] = f;
        }

        fillCubeInBox(L, W, H);
        if(state)
            System.out.println(count);
        else
            System.out.println(-1);
    }

    private static void fillCubeInBox(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0) return;

        int cubeSide = 0;
        boolean filled = false; // 실제로 큐브를 하나라도 넣었는지

        for (int i = 19; i >= 0; i--) {
            cubeSide = 1 << i;

            if (cubeSide > l || cubeSide > w || cubeSide > h) continue;
            if (cube[i] == 0) continue;

            cube[i]--;
            count++;
            filled = true;
            break;
        }

        if (!filled) {
            state = false;
            return;
        }

        fillCubeInBox(l, w, h - cubeSide);
        fillCubeInBox(cubeSide, w - cubeSide, cubeSide);
        fillCubeInBox(l - cubeSide, w, cubeSide);
    }

}
