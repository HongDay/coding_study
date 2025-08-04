package kakao4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ksm_prob2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int v = h * w * l;
            list.add(v);
        }
        Collections.sort(list);

        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            n -= list.get(i);
            count++;

            if (n <= 0) {
                bw.write(String.valueOf(count));
                break;
            }
        }

        if (n > 0) bw.write("-1");
        bw.flush();
        bw.close();
        br.close();
    }
}
