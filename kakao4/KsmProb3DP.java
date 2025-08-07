package kakao4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KsmProb3DP {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n;
    int[] count;
    ArrayList<Integer> starList = new ArrayList<>();

    private void star() throws IOException {
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            starList.add(Integer.parseInt(st.nextToken()));
        }

        count = new int[n];

        //dp(n - 1);
        //Arrays.sort(count);
        //bw.write(String.valueOf(count[n-1]));
        dp();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, count[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();

    }

    private void dp() {
        for (int i = 0; i < n; i++) {
            // i번째 별의 높이가 i보다 크면 주울 수 있음 (1번째 별(index: 0)은 시간이 1 이상일 때 주울 수 있음)
            if (starList.get(i) >= i + 1) count[i] = 1;
            else continue;

            for (int j = 0; j < i; j++) {
                // i번째 별을 줍고 j번째 별을 줍는 경우
                if (starList.get(i) >= starList.get(j) + i - j) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
    }

    // 재귀 -> 스택 오버플로우 문제가 있어서 권장되진 않음
    /*private void dp(int index) {
        if (starList.get(index) > index) {      // index번째의 별의 높이가 index보다 높으면 주울 수 있음 (ex: 1번째 별 (index: 0)의 높이는 1 이상이어야함.
            count[index] = 1;
        }

        if (index == 0) {
            return;
        }

        dp(index - 1);

        for (int i = 0; i < index; i++) {
            if (starList.get(index) >= starList.get(i) + index - i) {      // i번째 별을 줍고 index번째 별도 주울 수 있다면
                if(count[i]>0) count[index] = Math.max(count[index], count[i] + 1);
            }
        }
    }*/


    public static void main(String[] args) throws Exception {
        KsmProb3DP prob3 = new KsmProb3DP();
        prob3.star();
    }
}

