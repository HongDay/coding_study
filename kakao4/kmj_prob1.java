import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String S = st.nextToken();
        String c = st.nextToken();


        String result;
        if (c.equals(Character.toString(S.charAt(N - 1)))) System.out.print(S.substring(0, N - 1));
        else System.out.print(S + c);
    }
}