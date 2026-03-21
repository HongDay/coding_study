package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1941 {

    public static char[][] cl = new char[5][5];
    public static int[] selections = new int[7];
    public static boolean[] visited = new boolean[7];

    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            String line = br.readLine();
            for (int j = 0; j < 5; j++){
                cl[i][j] = line.charAt(j);
            }
        }

        System.out.println(backtracking(0, 0, 0));

    }

    private static int backtracking(int y, int cur, int depth) {

        if (y > 3){
            return 0;
        }

        if (depth == 7) {
            visited = new boolean[7];
            visited[0] = true;
            dfs(0);
            for (int i = 0; i < 7; i++) {
                if (!visited[i]) {
                    return 0;
                }
            }
            return 1;
        }

        int answer = 0;
        for (int i = cur; i < 25; i++){
            int curY = cl[i/5][i%5] == 'Y' ? y + 1 : y;
            selections[depth] = i;
            answer += backtracking(curY, i + 1, depth + 1);
        }

        return answer;
    }

    private static void dfs(int cur){
        for (int i = 0; i < 7; i++){
            if (visited[i] || i == cur) {continue;}
            int r1 = selections[cur] / 5, c1 = selections[cur] % 5;
            int r2 = selections[i] / 5, c2 = selections[i] % 5;
            if (Math.abs(r1 - r2) + Math.abs(c1 - c2) == 1){
                visited[i] = true;
                dfs(i);
            }
        }
    }

}
