package kakao4;

import java.io.*;
import java.util.*;

public class day_prob1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		st.nextToken();
		String S = st.nextToken();
		String c = st.nextToken();

		if (S.endsWith(c)){
			System.out.println(S.substring(0, S.length() - 1));
		}
		else{
			System.out.println(S+c);
		}
	}
}