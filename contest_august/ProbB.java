package contest_august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProbB {

    private static String input;
    private static int len;
    private static int start;
    private static int end;

    public static void main (String[] argv) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        len = input.length();

        int score = 0;
        for (int i = 0; i < len - 2; i++){
            score += check(i, i+1, i+2);
        }

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            end = Integer.parseInt(st.nextToken());
            int answer = score;
            for (int i = start; i < end; i++){
                int changed = 0;
                changed += check(i-2, i-1, i+1);
                changed += check(i-1, i+1, i+2);
                changed -= check(i-2, i-1, i);
                changed -= check(i-1, i, i+1);
                changed -= check(i, i+1, i+2);
                answer = Math.max(answer, score + changed);
            }

            System.out.println(answer);
        }

    }

    private static int check(int a, int b, int c){
        if (a < start || b < start || c < start || a >= end+1 || b >= end+1 || c >= end+1){return 0;}
        if (input.charAt(a) == '+' && input.charAt(b) == '^' && input.charAt(c) == '+'){return 1;}
        if (input.charAt(a) == '-' && input.charAt(b) == '^' && input.charAt(c) == '-'){return -1;}
        return 0;
    }
}
