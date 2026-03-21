package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P14226 {
    public static void main (String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[2001][2001]; // 좌표 : {cur, clipboard}

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0}); // {cur S, second, clipboard}

        visited[1][0] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cur = current[0];
            int second = current[1];
            int clipboard = current[2];

            if (cur == S) {
                System.out.println(second);
                return;
            }

            // 복사
            if (!visited[cur][cur]){
                queue.offer(new int[]{cur, second + 1, cur});
                visited[cur][cur] = true;
            }

            // 붙여넣기
            if (clipboard > 0 && cur + clipboard < 2001 && !visited[cur + clipboard][clipboard]){
                queue.offer(new int[]{cur + clipboard, second + 1, clipboard});
                visited[cur + clipboard][clipboard] = true;
            }

            // 삭제
            if (cur > 0 && !visited[cur - 1][clipboard]){
                queue.offer(new int[]{cur - 1, second + 1, clipboard});
                visited[cur - 1][clipboard] = true;
            }

        }


    }
}
