package prob28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb28 {

    private static int[][] matrix;
    private static int N;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = divideConquer(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }

    private static int[][] divideConquer(long n){
        if (n == 1) {
            return matrix;
        } else {
            return square(divideConquer(n/2), divideConquer(n-n/2));
        }

    }

    private static int[][] square(int[][] a, int[][] b){
        int[][] midResult = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    midResult[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return midResult;
    }

}
