package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P27932 {
    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] max_diff = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        int prev = Integer.parseInt(st.nextToken());

        max_diff[0] = 0;

        for (int i = 2; i < n + 1; i++){
            int now = Integer.parseInt(st.nextToken());

            max_diff[i] = Math.abs(prev - now);
            max_diff[i - 1] = Math.max(max_diff[i], max_diff[i - 1]);

            prev = now;
        }

        Arrays.sort(max_diff);
        System.out.println(max_diff[n-k]);

    }
}
