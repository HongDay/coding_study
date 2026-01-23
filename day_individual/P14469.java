package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class P14469 {
    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int arrived = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());
            list.add(new int[]{arrived, duration});
        }

        list.sort((x,y) -> Integer.compare(x[0], y[0]));

        int total = 0;

        for (int[] cow : list){
            if (total < cow[0]) {
                total = cow[0];
            }
            total += cow[1];
        }

        System.out.println(total);

    }
}
