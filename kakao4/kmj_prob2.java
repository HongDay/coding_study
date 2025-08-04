import java.io.*;
import java.util.*;

class kmj_prob2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] boxList = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            boxList[i] = H * W * L;
        }

        Arrays.sort(boxList);

        int count = 0;
        for (int i = M - 1; i >= 0; i--) {
            count++;
            N -= boxList[i];
            if (N <= 0) break;
        }

        if (N > 0) count = -1;
        System.out.print(count);
    }
}