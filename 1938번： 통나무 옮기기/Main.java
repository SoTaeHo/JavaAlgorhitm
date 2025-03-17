import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

    static char[][] map;
    static int[][][] visited;
    static int n;
    static int bDir;
    static int eDir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bDir = 0;
        eDir = 0;
        map = new char[n][n];
        visited = new int[n][n][2];
        int bCnt = 0;
        int eCnt = 0;
        int bx = 0;
        int by = 0;
        int ex = 0;
        int ey = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'B') {
                    bCnt++;
                    if (bCnt == 2) {
                        bx = i;
                        by = j;
                    }
                    if (bCnt == 3) {
                        if (bx + 1 == i)
                            // 새로
                            bDir = 1;
                    }
                }
                if (map[i][j] == 'E') {
                    eCnt++;
                    if (eCnt == 2) {
                        ex = i;
                        ey = j;
                    }
                    if (eCnt == 3) {
                        if (ex + 1 == i)
                            eDir = 1;
                    }
                }
            }
        }
        System.out.println(bfs(bx, by, ex, ey));
        // // 출력
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.printf("%2d ", visited[i][j]);
        // }
        // System.out.println();
        // }
        // System.out.println(visited[ex][ey]);
    }

    static boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    static int bfs(int x, int y, int ex, int ey) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y][bDir] = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (bDir == 1) {// 새로
                // up

                // down

                // left

                // right

                // turn
            } else { // 가로
                // up

                // down

                // left

                // right

                // turn
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}