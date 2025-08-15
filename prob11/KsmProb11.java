package prob11;

import java.awt.*;
import java.io.*;
import java.util.*;

public class KsmProb11 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] distX = {0, -1, 0, 1};
    int[] distY = {1, 0, -1, 0};

    private void zelda() throws IOException {
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem " + (index++) + ": " + bfs(cave) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int[][] cave) {
        PriorityQueue<Point> q = new PriorityQueue<>(
                Comparator.comparingInt(p -> cave[p.y][p.x])
        );

        Integer[][] rupee = new Integer[cave.length][cave.length];

        q.add(new Point(0, 0));
        rupee[0][0] = cave[0][0];

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == cave.length - 1 && p.y == cave.length - 1) continue;

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + distX[i];
                int nextY = p.y + distY[i];

                if (nextX < 0 || nextX >= cave.length || nextY < 0 || nextY >= cave.length) continue;

                int addRupee = rupee[p.y][p.x] + cave[nextY][nextX];

                if(rupee[nextY][nextX] == null || rupee[nextY][nextX] > addRupee){
                    rupee[nextY][nextX] = addRupee;
                    q.add(new Point(nextX, nextY));
                }
            }
        }

        return rupee[cave.length - 1][cave.length - 1];
    }

    public static void main(String[] args) throws Exception {
        KsmProb11 main = new KsmProb11();
        main.zelda();
    }
}
