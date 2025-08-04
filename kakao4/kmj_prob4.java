import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int result = 0;
        while (!q.isEmpty()) {

            ArrayList<Integer> dests = new ArrayList<>();

            int initSize = q.size();

            for (int i = 0; i < initSize; i++) {

                int curNode = q.poll();

                if (arr[curNode] == 0) {
                    result++;
                }
                else if (!dests.contains(arr[curNode])) {
                    dests.add(arr[curNode]);
                    q.add(arr[curNode]);
                }
                else continue;
            }
        }

        System.out.print(result);
    }
}