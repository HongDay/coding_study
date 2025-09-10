package prob26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb26 {

    private static boolean[][] board;
    private static int[] horseX = {2,2,1,1,-1,-1,-2,-2};
    private static int[] horseY = {1,-1,2,-2,2,-2,1,-1};
    private static int[] monkeyX = {1,0,0,-1};
    private static int[] monkeyY = {0,1,-1,0};
    private static int min = 40000;
    private static int W;
    private static int H;
    private static int K;

    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new boolean[H][W];

        for (int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++){
                board[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        if (board[0][0] || board[H-1][W-1]){
            System.out.println(-1);
            return;
        }
        // DFS
        DFS(0,0,0,0);
        System.out.println(min == 40000 ? -1 : min);
    }

    private static int DFS(int Kused, int cur, int x, int y){

        if (cur >= min) {return 40000;}
        if (x == W-1 && y == H-1) {return cur;}

        // 4개 방위 +1 체크
        for (int i = 0; i < 4; i++) {
            int newX = x + monkeyX[i];
            int newY = y + monkeyY[i];
            if (newX < 0 || newX >= W || newY < 0 || newY >= H) {
                continue;
            }
            if (board[newY][newX]) {
                continue;
            }

            board[newY][newX] = true;
            int now = DFS(Kused, cur + 1, newX, newY);
            board[newY][newX] = false;

            if (now < min) {min = now;}
        }

        if (Kused < K) {
            // 8개 후보 모두 체크
            for (int i = 0; i < 8; i++){
                int newX = x+horseX[i];
                int newY = y+horseY[i];
                if (newX < 0 || newX >= W || newY < 0 || newY >= H) {continue;}
                if (board[newY][newX]) {continue;}

                board[newY][newX] = true;
                int now = DFS(Kused+1, cur+1, newX, newY);
                board[newY][newX] = false;

                if (now < min) {min = now;}
            }
        }

        return 40000;
    }
}