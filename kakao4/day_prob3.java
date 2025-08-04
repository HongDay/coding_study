package kakao4;

import java.io.*;
import java.util.*;

public class day_prob3 {

	static int[] heights;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		heights = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			int height = Integer.parseInt(st.nextToken());
			heights[i] = height - i - 1;
		}

		int answer = star(0, 0);
		System.out.println(answer);

	}


	static int star(int idx, int time){
		
		// base case
		if (idx == heights.length){
			return 0;
		}

		// If it is grabable
		if (heights[idx] - time >= 0){
			int grab = 1 + star(idx + 1, heights[idx]);
			int move = star(idx + 1, time);
			return Math.max(grab, move);
		} else { // If not grabale, just move
			return star(idx + 1, time);
		}
	}
}