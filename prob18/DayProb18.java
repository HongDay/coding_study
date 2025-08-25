package prob18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb18 {

    private static int N;
    private static int M;
    private static int H;
    private static boolean[][] garo;
    private static int answer;

    public static void main (String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        garo = new boolean[H][N-1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int hori = Integer.parseInt(st.nextToken()) - 1;
            int verti = Integer.parseInt(st.nextToken()) - 1;
            garo[hori][verti] = true;
        }

        answer = -1;
        answer = makeLadder();
        System.out.print(answer);

    }

    private static int makeLadder () {
        // 0
        if (playLadder()) {
            return 0;
        }

        // 1
        for (int i = 0; i < H*(N-1); i++){
            int row = i / (N-1);
            int col = i % (N-1);

            if (garo[row][col]){continue;}
            if (col-1 >= 0 && garo[row][col-1]){continue;}
            if (col+1 < N-1 && garo[row][col+1]){continue;}

            garo[i/(N-1)][i%(N-1)] = true;
            if (playLadder()){return 1;}
            garo[row][col] = false;
        }

        // 2
        for (int i = 0; i < H*(N-1); i++){
            int row = i / (N-1);
            int col = i % (N-1);

            if (garo[row][col]){continue;}
            if (col-1 >= 0 && garo[row][col-1]){continue;}
            if (col+1 < N-1 && garo[row][col+1]){continue;}

            garo[row][col] = true;

            for (int j = i+1; j < H*(N-1); j++){
                int row2 = j / (N-1);
                int col2 = j % (N-1);

                if (garo[row2][col2]){continue;}
                if (col2-1 >= 0 && garo[row2][col2-1]){continue;}
                if (col2+1 < N-1 && garo[row2][col2+1]){continue;}

                garo[row2][col2] = true;
                if (playLadder()){return 2;}
                garo[row2][col2] = false;
            }
            garo[row][col] = false;
        }

        // 3
        for (int i = 0; i < H*(N-1); i++){
            int row = i / (N-1);
            int col = i % (N-1);

            if (garo[row][col]){continue;}
            if (col-1 >= 0 && garo[row][col-1]){continue;}
            if (col+1 < N-1 && garo[row][col+1]){continue;}

            garo[row][col] = true;

            for (int j = i+1; j < H*(N-1); j++){
                int row2 = j / (N-1);
                int col2 = j % (N-1);

                if (garo[row2][col2]){continue;}
                if (col2-1 >= 0 && garo[row2][col2-1]){continue;}
                if (col2+1 < N-1 && garo[row2][col2+1]){continue;}

                garo[row2][col2] = true;

                for (int k = j+1; k < H*(N-1); k++){
                    int row3 = k / (N-1);
                    int col3 = k % (N-1);

                    if (garo[row3][col3]){continue;}
                    if (col3-1 >= 0 && garo[row3][col3-1]){continue;}
                    if (col3+1 < N-1 && garo[row3][col3+1]){continue;}

                    garo[row3][col3] = true;
                    if (playLadder()){return 3;}
                    garo[row3][col3] = false;
                }
                garo[row2][col2] = false;
            }
            garo[row][col] = false;
        }

        return -1;
    }

    private static boolean playLadder() {
        for (int i = 0; i < N; i++){
            int now = i;
            for (int j = 0; j < H; j++){
                if (now - 1 >= 0 && garo[j][now - 1]){
                    now -= 1;
                } else if (now < N-1 && garo[j][now]) {
                    now += 1;
                }
            }
            if (now != i) {return false;}
        }
        return true;
    }

}
