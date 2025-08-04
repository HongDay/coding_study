package kakao4;

import java.io.*;
import java.util.*;

public class ksm_prob4 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void collision() throws IOException {
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();        // 컨테이너 별 다음 목적지

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 현재 위치의 다음 목적지 컨테이너. hashset이 contains 함수 처리 시 시간 복잡도가 평균 O(1)로 빠름
        // 중복을 자동으로 제거하기 때문에 따로 contains 함수 같이 이미 저장되어있는지 확인하지 않아도 됨.
        HashSet<Integer> selected = new HashSet<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);

            // 다음 목적지가 0번 컨테이너면 count++
            if (num == 0) {
                count++;
                continue;
            }
            // 아니면 추가
            selected.add(num);
        }

        count += selection(list, selected);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private int selection(ArrayList<Integer> list, HashSet<Integer> selected) {
        int count = 0;

        while (!selected.isEmpty()) {
            // 다음 목적지 컨테이너
            HashSet<Integer> nextSelect = new HashSet<>();

            // selected에서 현재 컨테이너를 가져옴
            for (int current : selected) {
                // list.get(current-1)을 통해 다음 목적지 컨테이너 값을 가져옴
                int nextNum = list.get(current - 1);

                // nextNum (다음 목적지)가 0번째 컨테이너면 count++
                if (nextNum == 0) {
                    count++;
                    continue;
                }

                // 다음 목적지가 0번째가 아니면 다음 목적지 컨테이너 hashset에 추가
                nextSelect.add(nextNum);
            }
            // 이제 다음으로 넘어가기 위해 nextSelect를 selected에 넣음.
            selected.clear();
            selected.addAll(nextSelect);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        ksm_prob4 main = new ksm_prob4();
        main.collision();
    }
}
