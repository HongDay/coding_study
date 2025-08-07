package kakao4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KsmProb3BFS {
    // 현재 위치, 시간, 개수 저장
    static class Person{
        int index;
        int sec;
        int count;

        public Person(int index, int sec, int count){
            this.index=index;
            this.sec=sec;
            this.count=count;
        }
    }

    private static int BFS(ArrayList<Integer> starList){
        Queue<Person> q = new LinkedList<>();
        q.offer(new Person(0,1,0));

        int max=0;
        while(!q.isEmpty()){
            Person person = q.poll();

            // 마지막 위치에 도달했다면
            if(person.index==starList.size()){
                // max에 저장된 값과 획득한 별의 개수 중 큰 값을 max에 저장함
                max=Math.max(max, person.count);
                continue;
            }

            // 해당 index에 도착했을 때 별의 높이가 0이라면 별의 개수(person.count) 증가
            if(person.sec==starList.get(person.index)){
                person.count++;
            }

            // 해당 index에 도착했을 때 별의 높이가 0보다 크다면
            if(person.sec<starList.get(person.index)){
                // 기다림
                q.offer(new Person(person.index, person.sec+1, person.count));
            }
            // 다음 위치로 이동
            q.offer(new Person(person.index+1, person.sec+1, person.count));
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        ArrayList<Integer> starList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            starList.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(BFS(starList));
    }
}