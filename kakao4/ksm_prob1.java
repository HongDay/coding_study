package kakao4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ksm_prob1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n=Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        char g = st.nextToken().charAt(0);

        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, n-1);

        if(s.charAt(n-1)!=g){
            sb.append(s.charAt(n-1));
            sb.append(g);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
