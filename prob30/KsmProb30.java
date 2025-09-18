package prob30;

import java.io.*;

public class KsmProb30 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n;
    StringBuilder sb = new StringBuilder();

    private void mooGame() throws IOException {
        n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            if (n == 0) bw.write("m");
            else bw.write("o");
        } else {
            int exKLength = 3;
            int k = 1;
            while (true) {
                exKLength = exKLength * 2 + (k++) + 3;
                if (exKLength >= n) break;
            }

            bw.write(findChar(exKLength, k - 1));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private String findChar(int kLength, int k) {
        int left = (kLength - (k + 3)) / 2;

        // 왼쪽 편 또는 오른쪽 편에 있을 때
        if (n <= left) return findChar(left, k - 1);
        if (n >= (left + k + 4)) {
            n -= left + k + 3;
            return findChar(left, k - 1);
        }

        // 가운데에 있을 때
        if (n == left + 1) return "m";
        return "o";
    }

    public static void main(String[] args) throws Exception {
        KsmProb30 main = new KsmProb30();
        main.mooGame();
    }
}
