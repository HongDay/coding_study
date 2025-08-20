package prob14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayProb14 {

    private static int[] remote = new int[10];
    private static String goal;

    public static void main(String[] argv) throws IOException {
        for (int i = 0; i < 10; i++){
            remote[i] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        goal = br.readLine();
        int goalInt = Integer.parseInt(goal);
        int N = Integer.parseInt(br.readLine());

        if (N > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                int broken = Integer.parseInt(st.nextToken());
                remote[broken] = 10;
                // System.out.println(broken);
            }
        }

        // 98~102 사이고, 직접 입력할 수 없는 경우도 추가

        // 101 은 입력할 수 있는데 100은 못하는 경우 ->

        // 그냥 시작이 100인 경우
        if (goalInt == 100) {
            System.out.println("0");
        } else {
            String result = minClick(0);
//            int moveInt = minClick2(goalInt);
//            String result = moveInt + "";

            // System.out.println(result);

            int resultLen = result.length();
            int resultInt = Integer.parseInt(result);
            System.out.println(resultLen + Math.abs(resultInt - goalInt));
        }
    }

    private static int minClick2(int goalInt){
        int plus = 0;
        int minus = 0;
        while(true){
            if (move(goalInt + plus++)){
                return goalInt + (plus - 1);
            } else if (goalInt + minus > 0 && move(goalInt + minus--)){
                return goalInt + (minus + 1);
            }
        }
    }

    private static boolean move(int moved){
        String newGoal = moved + "";
        for (int i = 0; i < newGoal.length(); i++){
            int target = newGoal.charAt(i) - '0';
            if (remote[target] == 10) {
                return false;
            }
        }
        return true;
    }


    // 칠 수 있는 제일 가까운 숫자를 찾는 함수
    private static String minClick(int cur){
        if (cur == goal.length()) {return "";}

        int now = goal.charAt(cur) - '0';
// 현재 자릿수에서 가장 가까운 수를 찾아야되는건 맞는데,
        // 그 다음숫자도 그 다음 자릿수에서 가장 가까운 수를 찾아야되는건 아님.
        // 80000 에서, 8이 안되면 7을 찾고 그 다음으로 이동하느데, 그 다음은 그냥 또 0이랑 가까운거를 찾음.
        // 앞에 8의 결과와 전혀 무관하게 되버림..
        for (int i = 0; i < 9; i++){
            if (now + i + 1 < 10 && now - i >= 0 && remote[now + i + 1] != 10 && remote[now - i] != 10){
                String next = minClick(cur + 1);
                if (next != "" && next.charAt(0) != goal.charAt(cur + 1)){
                    int nextFirst = next.charAt(0) - '0';
                    if (nextFirst < 5) {
                        int here = now + i + 1;
                        return here + next;
                    }else {
                        int here = now - i;
                        return here + next;
                    }
                }
            }
            if (now - i >= 0 && remote[now - i] != 10) {
                return remote[now - i] + minClick(cur + 1);
            }
            if (now + i + 1 < 10 && remote[now + i + 1] != 10) {
                return remote[now + i + 1] + minClick(cur + 1);
            }
        }

        // 이게 나오면 문제가 오류가 있는 경우임. (컴파일을 위해 추가)
        return "@";
    }

}
