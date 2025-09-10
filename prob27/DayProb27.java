package prob27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayProb27 {
    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String messi1 = "M";
        String messi2 = "M G";
        String messiNew = "";

        int mess1 = 5;
        int mess2 = 13;
        int mess = 0;

        while (mess < N){
            messiNew = messi2 + " " + messi1;
            mess = mess1 + mess2 + 1;
            messi1 = messi2;
            mess1 = mess2;
            messi2 = messiNew;
            mess2 = mess;
        }

        int cur = messiNew.length();

        while (mess > 0) {
            char now = messiNew.charAt(cur-1);
            if (now == 'M'){
                if (mess - 5 < N){
                    System.out.println("Messi".charAt(N + 5 - mess - 1));
                    break;
                }
                mess -= 5;
                cur --;
            } else if (now == 'G') {
                if (mess - 7 < N){
                    System.out.println("Gimossi".charAt(N + 7 - mess - 1));
                    break;
                }
                mess -= 7;
                cur --;
            } else {
                if (mess == N){
                    System.out.println("Messi Messi Gimossi");
                    break;
                }
                mess --;
                cur --;
            }
        }
    }
}
