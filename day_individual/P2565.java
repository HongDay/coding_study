package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2565 {

    static List<int[]> elec;
    static int[] maxnum;
    static int N;

    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        elec = new ArrayList<>();
        maxnum = new int[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            elec.add(new int[]{x, y});
        }

        // elec 정렬 필요?
        // DP 쓰면 정렬 불필요?
        elec.sort((a, b) -> a[0] - b[0]);

        dp(N);

        int answer = N - Arrays.stream(maxnum).max().getAsInt();
        System.out.print(answer);

    }

    static void dp(int len){
        for (int i = 0; i < len; i++){
            maxnum[i] = 1;
            for (int j = 0; j < i; j++){
                if(elec.get(j)[1] < elec.get(i)[1]){
                    maxnum[i] = Math.max(maxnum[i], maxnum[j] + 1);
                }
            }
        }
    }

}
