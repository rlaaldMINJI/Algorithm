package DFSBFS;

import java.util.*;

//섬의 개수를 세는 프로그램 작성
//bfs
public class No4963 {

    int h;
    int w;
    int result;
    int[] dx = {0,-1,-1,-1,0,1,1,1};
    int[] dy = {-1,-1,0,1,1,1,0,-1};


    public void solve(){
        Scanner sc = new Scanner(System.in);

        while(true){ //입력받음
            result = 0;
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0)
                break;

            int[][] map = new int[h][w];
            int[][] visited = new int[h][w];

            for(int i=0;i<h;++i){
                for(int j=0;j<w;++j){
                    int x = sc.nextInt();
                    map[i][j] = x;
                }

            }

            for(int i=0;i<h;++i){
                for(int j=0;j<w;++j){
                    if(map[i][j] == 1 && visited[i][j] == 0) {
                        BFS(i, j, map, visited);
                    }
                }

            }

            System.out.println(result);
        }
    }

    public void BFS(int i,int j, int[][] map, int[][] visited){
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j});
        visited[i][j] = 1;

        int[] xy = new int[2];
        int ax,ay;

        while(que.size() > 0) {
            xy = que.pop();

            for (int c = 0; c < dx.length; ++c) {
                ax = xy[0] + dx[c];
                ay = xy[1] + dy[c];

                //map.length -> row의 길이(세로줄 개수)
                //map[0].length ->  1번째 행의 원소수(첫번째 row의 column개수)
//                if (ax < 0 || ax >= h || ay < 0 || ay >= w) {
//                    continue;
//                }

                if(IsInMap(ax,ay)) {
                    if (map[ax][ay] == 1 && visited[ax][ay] == 0) {
                        que.offer(new int[]{ax, ay});
                        visited[ax][ay] = 1;
                    }
                }

            }
        }
        result++;
    }


    public boolean IsInMap(int x, int y){
        if(x >= 0 && x < h && y >= 0 && y < w)
            return true;

        return false;
    }

    public static void main(String[] args) {
        No4963 no4963 = new No4963();
        no4963.solve();
    }
}

