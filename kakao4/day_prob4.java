import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] next = new int[N];

		for (int i = 0; i < N; i++){
			next[i] = Integer.parseInt(st.nextToken());
		}

		int zerocount = 0;
		int cannotcount = 0;
		while(zerocount + cannotcount < N){
		int[] cur = new int[N];
			for (int i = 0; i < N; i++){
				if (next[i] == 0){
					cur[i] = -1;
					zerocount ++;
				}
				if (cur[next[i]] < 1){
					cur[next[i]] = i;
				}
				else{
					cur[i] = -1;
					cannotcount ++;
				}
			}
		}

		// 1 2 3 4 5 6 7 8 9
		// 3 1 5 3 0 7 5 9 7
		
		System.out.println(zerocount);
	}
}