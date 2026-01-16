package prob34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb34 {
    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        double twos = Math.pow(2, d);
        String loc = st.nextToken();

        st = new StringTokenizer(br.readLine());
        double movex = Double.parseDouble(st.nextToken());
        double movey = Double.parseDouble(st.nextToken());

        double firstx = 0;
        double firsty = 0;
        double plus = twos;
        for (int i = d-1; i >= 0; i--) {
            plus /= 2;
            char cur = loc.charAt(i);
            if (cur == '2') {
                firstx += plus;
            } else if (cur == '3') {
                firstx += plus;
                firsty += plus;
            } else if (cur == '4') {
                firsty += plus;
            }
        }

        double afterx = firstx + movex;
        double aftery = firsty + movey;
        plus = twos;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < d; i++){
            plus /= 2;
            boolean xcheck = (afterx > plus);
            boolean ycheck = (aftery > plus);

            if (!xcheck & !ycheck) {
                answer.append("1");
            } else if (xcheck & !ycheck) {
                answer.append("2");
            } else if (xcheck & ycheck) {
                answer.append("3");
            } else {
                answer.append("4");
            }
        }

        System.out.println(answer.toString());
    }
}
