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

    static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    static boolean isRotate(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (!isValid(nx, ny) || map[nx][ny] == '1') {
                return false;
            }
        }
        return true;
    }

    static int bfs(int bx, int by, int ex, int ey) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(bx, by, bDir));
        visited[bx][by][bDir] = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();

            int x = p.x;
            int y = p.y;
            System.out.printf("x : %d, ex : %d, y : %d, ey : %d, bDir : %d, eDir : %d\n", x, ex, y, ey, bDir, eDir);
            if (x == ex && y == ey && bDir == eDir) {
                return visited[ex][ey][bDir];
            }
            if (bDir == 1) {// 새로

                // up
                int nx = p.x - 1;
                int ny = p.y;
                int nnx = p.x - 2;
                if (isValid(nnx, ny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // down
                nx = p.x + 1;
                ny = p.y;
                nnx = p.x + 2;
                if (isValid(nnx, ny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // left
                nx = p.x;
                ny = p.y - 1;
                if (isValid(nx, ny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // right
                nx = p.x;
                ny = p.y + 1;
                if (isValid(nnx, ny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // turn
                if (isRotate(p.x, p.y)) {
                    visited[x][y][0] = visited[x][y][1] + 1;
                    bDir = 0;
                    q.offer(new Point(x, y, bDir));
                }
            } else { // 가로
                // up
                int nx = p.x - 1;
                int ny = p.y;
                if (isValid(nx, ny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // down
                nx = p.x + 1;
                ny = p.y;
                if (isValid(nx, ny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // left
                nx = p.x;
                ny = p.y - 1;
                int nny = p.y - 2;
                if (isValid(nx, nny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // right
                nx = p.x;
                ny = p.y + 1;
                nny = p.y + 2;
                if (isValid(nx, nny) && visited[nx][ny][bDir] == 0 && map[nx][ny] != '1') {
                    q.offer(new Point(nx, ny, bDir));
                    visited[nx][ny][bDir] = visited[x][y][bDir] + 1;
                }
                // turn
                if (isRotate(p.x, p.y)) {
                    visited[x][y][1] = visited[x][y][0] + 1;
                    bDir = 1;
                    q.offer(new Point(x, y, bDir));
                }
            }
        }
        return 0;
    }

    static class Point {
        int x;
        int y;
        int dir;

        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}