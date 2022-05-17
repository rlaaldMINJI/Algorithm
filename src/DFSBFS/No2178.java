package DFSBFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//미로탐색
//BFS(최단거리)
public class No2178 {
    int M;
    int N;
    int[] h = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    int result;

    public void solve(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();;
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        for(int n = 0;n<N;++n){ //맵에 값넣어주기
            int ln = sc.nextInt();
            String line = Integer.toString(ln);
            for(int m = 0;m<M;++m){
                map[n][m] =Integer.parseInt(line.substring(m,m+1));
            }
        }

        BFS(N,M,map,visited);
//        System.out.println(r);

    }

    public void BFS(int i,int j,int[][] map, int[][]visited){
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0,0,1});
        visited[0][0] = 1;
        int ax = 0;
        int ay = 0;
        int[] xy = new int[2];
        while (que.size() > 0) {

            xy = que.pop();
            if(xy[0]==N-1&&xy[1]==M-1){
                System.out.println(xy[2]);
                return;
            }
            for (int c = 0; c < h.length; ++c) {
                ax = xy[0] + h[c];
                ay = xy[1] + y[c];

                if(IsInMap(ax,ay)){
                    if(map[ax][ay] == 1 && visited[ax][ay] == 0){
                        que.offer(new int[]{ax,ay,xy[2]+1});
                        visited[ax][ay] = 1;

                    }
                }

            }


        }
    }

    public boolean IsInMap(int x, int y){
        if(x >=0 && x < N && y >=0 && y < M)
            return true;
        return false;
    }

    public static void main(String[] args) {
        No2178 no2178 = new No2178();
        no2178.solve();
    }


}


