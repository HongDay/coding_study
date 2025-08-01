import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] boxes = new int[1001];

		for (int i = 0; i < M; i ++){
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			boxes[H*W*L]++;
		}

		int answer = 0;
		
		for (int i = 1000; i > 0; i--) {
			if (boxes[i] > 0){
				answer += boxes[i];
				N -= (i*boxes[i]);
				if (N <= 0){
					break;
				}
			}
		}
		if (N > 0){
			answer = -1;
		}

		System.out.println(answer);
	}
}