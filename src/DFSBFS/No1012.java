package DFSBFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class No1012 {

    int T;
    int M;
    int N;
    int K;
    int[] h = {0,0,-1,1};   //행
    int[] y = {1,-1,0,0};   //열
    int result;



    public void solve(){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t=0;t<T;++t){ //테스트케이스만큼 입력받음
            result = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            int[][] map = new int[N][M];
            int[][] visited = new int[N][M];

            K = sc.nextInt();
            for(int k=0;k<K;k++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            for(int i=0;i<N;++i){
                for(int j=0;j<M;++j){
                    if(map[i][j] == 1 && visited[i][j] == 0){
                        BFS(i,j,map,visited);
                        result++;
                    }
                }
            }

        System.out.println(result);
        }
    }

    public void BFS(int i,int j,int[][] map,int[][] visited){
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j});
        visited[i][j] = 1;


        int ax,ay;
        int[] xy = new int[2];

        while (que.size() > 0){

            xy = que.pop();

            for(int l=0;l<h.length;++l){
                ax = xy[0] + h[l];
                ay = xy[1] + y[l];

                if(IsInMap(ax,ay)){
                    if(map[ax][ay] == 1 && visited[ax][ay] == 0){
                        que.offer(new int[]{ax,ay});
                        visited[ax][ay] = 1;
                    }
                }
            }
        }


    }

    public boolean IsInMap(int x, int y){
        if(x >= 0 && x < N && y >= 0 && y < M)
            return true;

        return false;
    }

    public static void main(String[] args) {
        No1012 no1012 = new No1012();
        no1012.solve();
    }

}
