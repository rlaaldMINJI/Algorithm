package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No4963 {
    static int[] h = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] y = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            result=0;
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0)
                break;
            int[][] arr = new int[h][w];
            visited = new boolean[arr.length][arr[0].length];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1&&visited[i][j]==false)
                        bfs(i, j, arr);
                }
            }

            System.out.println(result);

        }
    }

    static void bfs(int i, int j, int[][] arr) {
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(i, j));
        visited[i][j] = true;
        Data re;
        int ax, ay;
        while (!q.isEmpty()) {
            re = q.poll();

            for (int k = 0; k < 8; k++) {
                ax = re.x + y[k];
                ay = re.y + h[k];
                if (ax < 0 || ax >= arr.length || ay < 0 || ay >= arr[0].length) {
                    continue;
                }
                if (visited[ax][ay]) {
                    continue;
                }
                if (arr[ax][ay] == 0) {
                    continue;
                }

                q.offer(new Data(ax, ay));
                visited[ax][ay] = true;
            }
        }
        result++;
    }

    static class Data {
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

