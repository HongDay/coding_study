package prob18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KmjProb18 {
    private static int answer = -1;
    private static int N;
    private static int H;
    private static boolean[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a - 1][b - 1] = true;
        }

        int maxAdd = H * (N - 1) - M;
        for (int i = 0; i <= Math.min(3, maxAdd); i++) {
            buildLadder(0, i);
            if (answer != -1) break;
        }

        System.out.print(answer);

        br.close();
    }

    // 1. 반복문으로 추가 사다리 1 ~ (H * (N-1) - M)개 일 때 bt로 확인하기
    // 2. bt할 때 한 번 더 true 일 때랑 false 일 때 bt 으로 확인하기
    // 추가 사다리가 최대 3개까지니깐 반복문이 메모리랑 시간을 덜 쓸 것 같아서 반복문으로 해보기
    private static void buildLadder(int buildCnt, int maxBuild) {

        if (buildCnt == maxBuild) {
            if (checkIsValid()) answer = maxBuild;
            return ;
        }

        for (int i = 0; i < H; i++) {

            if (answer != -1) break;

            for (int j = 0; j < N - 1; j++) {

                if (answer != -1) break;

                if (ladder[i][j]) continue;
                if ((j + 1 < N && ladder[i][j + 1]) || (j - 1 >= 0 && ladder[i][j - 1])) continue;

                ladder[i][j] = true;
                buildLadder(buildCnt + 1, maxBuild);
                ladder[i][j] = false;
            }
        }
    }

    private static boolean checkIsValid() {
        for (int i = 0; i < N; i++) {
            int curCol = i;
            int curDepth = 0;
            while (curDepth < H) {
                if (ladder[curDepth][curCol]) curCol++;
                else if (curCol - 1 >= 0 && ladder[curDepth][curCol - 1]) curCol--;
                curDepth++;
            }
            if (curCol != i) return false;
        }

        return true;
    }
}
