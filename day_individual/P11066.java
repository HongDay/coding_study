package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11066 {
    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] pages;
        int[] cumulsum;
        int[][] dp;

        for (int i = 0; i < T; i++){
            int K = Integer.parseInt(br.readLine());
            pages = new int[K + 1];
            cumulsum = new int[K + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++){
                int nownum = Integer.parseInt(st.nextToken());
                pages[j] = nownum;
                cumulsum[j] = cumulsum[j - 1] + nownum;
            }

            dp = new int[K + 1][K + 1];

            for (int j = 1; j < K; j++){
                for (int l = 1; l <= K - j; l++){
                    dp[l][l + j] = Integer.MAX_VALUE;
                }
            }

            for (int j = 1; j < K; j++){
                for (int l = 1; l <= K - j; l++){
                    int nowsum = cumulsum[l + j] - cumulsum[l - 1];

                    for (int k = l; k < l + j; k++){
                        int newdp = dp[l][k] + dp[k + 1][l + j] + nowsum;
                        dp[l][l + j] = Math.min(dp[l][l + j], newdp);
                    }
                }
            }

            System.out.println(dp[1][K]);

        }
    }
}
