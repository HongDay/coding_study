package contest_august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProbA {

    private static String input;
    private static int len;

    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        len = input.length();

        int score = 0;
        for (int i = 0; i < len - 2; i++){
            score += check(i, i+1, i+2);
        }

        int answer = score;
        for (int i = 0; i < len; i++){
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

    private static int check(int a, int b, int c){
        if (a < 0 || b < 0 || c < 0 || a >= len || b >= len || c >= len){return 0;}
        if (input.charAt(a) == '+' && input.charAt(b) == '^' && input.charAt(c) == '+'){return 1;}
        if (input.charAt(a) == '-' && input.charAt(b) == '^' && input.charAt(c) == '-'){return -1;}
        return 0;
    }
}
