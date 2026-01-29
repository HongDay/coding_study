package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3067 {
    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dp;
        int[] coins;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            coins = new int[N];

            for (int j = 0; j < N; j++){
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            dp = new int[M+1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int j = 0; j < M + 1; j++){
                    if(j+coin > M) {continue;}
                    dp[j+coin] += dp[j];
                }
            }

            System.out.println(dp[M]);

        }

    }
}
