package kakao4;

import java.io.*;
import java.util.*;

public class day_prob3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			int height = Integer.parseInt(st.nextToken());
			heights[i] = height - i - 1;
		}

		int answer = star(0, heights);
		System.out.println(answer);

	}

		
	static int star(int idx, int[] heights){
		
		// base case
		if (idx == heights.length - 1){
			if (heights[idx] >= 0) {
				return 1;
			}
			else {
				return 0;
			}
		}

		// If it is grabable
		if (heights[idx] >= 0){
			int aftergrab[] = new int[heights.length];
			for (int i = 0; i < heights.length; i++){
				aftergrab[i] = heights[i] - heights[idx];
			}
			int grab = 1 + star(idx + 1, aftergrab);
			int move = star(idx + 1, heights);

			// compare the grab case and move case
			if (grab > move){
				return grab;
			}
			else {
				return move;
			}
		}

		// If not grabale, just move
		return star(idx + 1, heights);
	}
}