package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17471 {
    public static int mindiff = 1000;
    public static int N;
    public static int[] nodes;
    public static List<Integer>[] adjacent;
    public static int sumall;

    public static boolean[] selected;
    public static boolean[] reachable;

    public static void main (String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodes = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int people = Integer.parseInt(st.nextToken());
            nodes[i] = people;
            sumall += people;
        }

        adjacent = new ArrayList[N];

        for (int i = 0; i < adjacent.length; i++) {
            adjacent[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++){
                adjacent[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        for (int i = 1; i <= N / 2; i++){
            selected = new boolean[N];
            backtracking(0, 0, i);
        }

        if (mindiff == 1000) System.out.println(-1);
        else System.out.println(mindiff);

    }

    private static void backtracking(int start, int curDepth, int depth){
        if(curDepth == depth){
            reachable = new boolean[N];
            for (int i = 0; i < N; i++){
                if (selected[i]){
                    connecting(i);
                    break;
                }
            }
            for (int i = 0; i < N; i++){
                if (!selected[i]){
                    connecting(i);
                    break;
                }
            }
            for (int i = 0; i < N; i++){
                if(!reachable[i]){
                    return;
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++){
                if (selected[i]){sum += nodes[i];}
            }

            mindiff = Math.min(mindiff, Math.abs (sumall - 2 * sum));
            return;
        }

        for (int i = start; i < N; i++){
            selected[i] = true;
            backtracking(i + 1, curDepth + 1, depth);
            selected[i] = false;
        }

    }

    private static void connecting(int start){
        reachable[start] = true;
        for (int next : adjacent[start]){
            if ((selected[next] != selected[start]) || reachable[next]){continue;}
            connecting(next);
        }
    }


}
