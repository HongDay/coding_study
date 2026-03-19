package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026 {

    public static char[][] matrix;
    public static int N;
    public static boolean[][] visited;
    public static int[] addX = {-1, 0, 0, 1};
    public static int[] addY = {0, -1, 1, 0};

    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < N; j++){
                matrix[i][j] = line.charAt(j);
            }
        }

        int normal_area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if (!visited[i][j]){
                    DFS_normal(i, j);
                    normal_area++;
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if (matrix[i][j] == 'R'){
                    matrix[i][j] = 'G';
                }
            }
        }

        int disable_area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if (!visited[i][j]){
                    DFS_normal(i, j);
                    disable_area++;
                }
            }
        }

        System.out.println(normal_area + " " + disable_area);

    }

    private static void DFS_normal(int x, int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++){
            int newX = x + addX[i];
            int newY = y + addY[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= N){continue;}

            if (!visited[newX][newY] && matrix[newX][newY] == matrix[x][y]){
                DFS_normal(newX, newY);
            }
        }
    }


}
