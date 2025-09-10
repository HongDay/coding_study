package prob26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb26 {

    private static boolean[][] board;
    private static int[] horseX = {3,3,1,1,-1,-1,-3,-3};
    private static int[] horseY = {1,-1,3,-3,3,-3,1,-1};
    private static int[] monkeyX = {1,0,0,-1};
    private static int[] monkeyY = {0,1,-1,0};

    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        board = new boolean[W][H];

        for (int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < H; j++){
                board[i][j] = Boolean.getBoolean(st.nextToken());
            }
        }

        // DFS
        System.out.println(DFS(K,0, 0 ,0));

    }

    private static int DFS(int K, int cur, int x, int y){

        if (K <= cur) {
            // 4개 방위 +1 체크
            for (int i = 0; i < 4; i++){
                return DFS(K, cur+1, x, y);
            }
        } else {
            // 8개 후보 모두 체크
            for (int i = 0; i < 8; i++){
                return DFS(K, cur+1, x, y);
            }
        }

        return -1;
    }
}