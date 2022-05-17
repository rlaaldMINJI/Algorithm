package DFSBFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class No1260 {

    public int N;

    public void solve(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1;
        int M = sc.nextInt();;
        int start = sc.nextInt();
        int[][] map = new int[N][N];
        int[][] visited = new int[N][N];

        for(int i=0;i<M;i++){
            int fr = sc.nextInt();
            int to = sc.nextInt();
            map[fr][to] = 1;
            map[to][fr] = 1;
        }

        DFS(map,visited,start);

        System.out.println("\n");

        visited = new int[N][N]; //BFS를 돌기전 한번 초기화

        Deque<Integer> que= new ArrayDeque();
        que.add(start);
        BFS(map,visited,que);

    }

    //깊이 우선 탐색
    public void DFS(int[][] map,int[][] visited, int fr){
        System.out.printf("%d",fr); //맨 처음 정점 출력

        for(int i=0;i<N;++i){
            visited[i][fr] = 1;
        }

        for(int to=0;to<N;++to){
            if(map[fr][to] == 1 && visited[fr][to] == 0){
                DFS(map,visited,to);
            }
        }
    }

    //너비 우선 탐색
    //que를 이용해 탐색
    public void BFS(int[][] map, int[][] visited, Deque<Integer> que){
        while(que.size() > 0){
            Integer fr = que.pop();
            System.out.printf("%d",fr);

            for(int i=0;i<N;++i){
                visited[i][fr] = 1;
            }

            for(int to = 0;to<N;++to){
                if(map[fr][to] == 1 & visited[fr][to] == 0){
                    if(!que.contains(to)){
                        que.add(to);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        No1260 no1260 = new No1260();
        no1260.solve();
    }
}



