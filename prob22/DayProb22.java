package prob22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DayProb22 {

    private static PriorityQueue<Integer> pq;

    public static void main (String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] price = new int[N][2];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(price, (a, b) -> (b[1] - a[1])); // O(NlogN)

        pq = new PriorityQueue<>();
        // O(KlogK)
        for (int i = 0; i < K; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        // O(NlogK)
        int totalPrice = 0;

        for (int i = 0; i < N; i++){
            int targetWeight = price[i][0];
            if (pq.isEmpty()){break;}
            if (findAbleSmallest(targetWeight)){
                totalPrice += price[i][1];
            }
        }

        System.out.println(totalPrice);

    }

    private static boolean findAbleSmallest(int targetWeight){
        boolean result;
        if (pq.isEmpty()) {return false;}
        int SmallestVolumeBag = pq.poll();
        if (SmallestVolumeBag < targetWeight){
            result = findAbleSmallest(targetWeight);
            pq.add(SmallestVolumeBag);
        } else {
            return true;
        }
        return result;
    }

}
