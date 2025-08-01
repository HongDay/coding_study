import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String S = st.nextToken();
		String c = st.nextToken();

		String s = "" + S.charAt(S.length()-1);

		if (Objects.equals(s, c)){
			String answer = "";
			for (int i = 0; i < S.length()-1; i++){
				answer = answer + S.charAt(i);
			}
			System.out.println(answer);
		}
		else{
			System.out.println(S+c);
		}
		
	}
}