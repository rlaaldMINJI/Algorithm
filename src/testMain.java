import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class testMain {

    int N;  //N개의 줄 / 세로
    int M;  //가로
    int[] h = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    int result;

    public void solve(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        for(int n = 0;n < N; ++n){ //N개의 줄만큼 돌면서 map에 넣어주기
            int line = sc.nextInt();
            String lineStr = Integer.toString(line);
            for(int m = 0; m < M; ++m){
                map[n][m] = Integer.parseInt(lineStr.substring(m,m+1));
            }
        }
        BFS(map,visited);
    }

    public void BFS(int[][] map, int[][] visited){
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0,0,1});
        visited[0][0] = 1;
        int ax,ay;


        while(que.size() > 0){
            int[] xy = new int[3];

            xy = que.pop();

            if(xy[0] == N-1 && xy[1] == M-1){
                System.out.println(xy[2]);
                return;
            }

            for(int c = 0;c < h.length; ++c){
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

    public boolean IsInMap(int x,int y){
        if(x >= 0 && x < N && y >= 0 && y < M)
            return true;
        return false;
    }

    public static void main(String[] args) {
        testMain testMain = new testMain();
        testMain.solve();
    }




}
