package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P34668 {
    public static void main(String[] argv) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++){
            int m = Integer.parseInt(br.readLine());
            int turn = m / 50;

            int duration = 6 + turn * 12;
            int hour = 6 + duration / 60;
            int minute = duration % 60;

            if (hour > 23) {
                sb.append("-1");
                continue;
            }

            if (hour < 10) {sb.append("0").append(hour);}
            else {sb.append(hour);}
            sb.append(":");
            if (minute < 10) {sb.append("0").append(minute);}
            else {sb.append(minute);}
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

}
