package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class P34979 {
    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] school = new int[4][N];
        int[] addx = {0, 0, -1, 1};
        int[] addy = {-1, 1, 0, 0};

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int kind = Integer.parseInt(st.nextToken());
            int floor = Integer.parseInt(st.nextToken()) - 1;

            if (kind == 1) {
                int cls = Integer.parseInt(st.nextToken()) - 1;
                school[floor][cls]++;
                for (int j = 0; j < 4; j++){
                    int newx = cls + addx[j];
                    int newy = floor + addy[j];
                    if (newx < 0 || newx > N - 1 || newy < 0 || newy > 3) {continue;}
                    school[newy][newx]++;
                }
            }
            else {
                int maxcls = 1;
                int score = -1;
                for (int j = 0; j < N; j++){
                    if (school[floor][j] > score){
                        score = school[floor][j];
                        maxcls = j + 1;
                    }
                }
                System.out.println(maxcls);
            }
        }

        int maxfloor = 1;
        int maxclass = 1;
        int score = -1;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < N; j++){
                if (school[i][j] > score){
                    score = school[i][j];
                    maxfloor = i + 1;
                    maxclass = j + 1;
                }
            }
        }
        System.out.println(maxfloor + " " + maxclass);

    }
}
