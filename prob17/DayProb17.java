package prob17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb17 {

    private static int N;
    private static int[][] scores;
    private static int[] order = new int[9];
    private static boolean[] used = new boolean[9];
    private static int max = 0;

    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        scores = new int[N][9];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++){
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        used[0] = true;
        makeOrder(0);

        System.out.println(max);

    }

    // 백트래킹으로 가능한 모든 순열에서 점수 계산
    private static void makeOrder(int now){
        // 4번 타자는 이미 1번 선수로 확정됨.
        if (now == 3) {
            makeOrder(now + 1);
        }
        if (now == 9) {
            // 계산 후 최대점수 업데이트
            int thisScore = calScore();
            if (thisScore > max){max = thisScore;}
            for (int ord : order){
            }
        }
        for (int i = 1; i < 9; i++){
            if (used[i]) {continue;}
            order[now] = i;
            used[i] = true;
            makeOrder(now + 1);
            used[i] = false;
            order[now] = 0;
        }
    }

    private static int calScore(){
        int score = 0;
        int p = 0;

        // 이닝
        for (int j = 0; j < N; j++){
            int[] ru = {0,0,0,0};
            int outcount = 0;

            while (outcount < 3){
                int player = order[p % 9];

                if (scores[j][player] == 0) {
                    outcount++;
                } else if (scores[j][player] == 4){
                    ru[0] = 1;
                    for (int i = 0; i < 4; i++){
                        score += ru[i];
                        ru[i] = 0;
                    }
                } else {
                    ru[0] = 1;
                    int ruta = scores[j][player];
                    for (int i = 3; i >= 0; i--){
                        if (ru[i] == 0){continue;}
                        if (i + ruta >= 4){
                            score++;
                            ru[i] = 0;
                        } else {
                            ru[i] = 0;
                            ru[i + ruta] = 1;
                        }
                    }
                }

                p++;
            }
        }
        return score;
    }
}
