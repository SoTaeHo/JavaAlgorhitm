import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA2117_등산로_조성 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tcase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ans = 0;

            int[][] map = new int[n][n];
            List<Point> li = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (li.isEmpty()) {
                        li.add(new Point(i, j));
                    } else if (map[li.get(0).x][li.get(0).y] < map[i][j]) {
                        li.clear();
                        li.add(new Point(i, j));
                    } else if (map[li.get(0).x][li.get(0).y] == map[i][j]) {
                        li.add(new Point(i, j));
                    }
                }
            }
            int[][] visited;
            for (Point p : li) {
                // System.out.printf("%d %d\n", p.x, p.y);
                visited = new int[n][n];
                dfs(map, visited, p.x, p.y, 1);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (p.x == i && p.y == j)
                            continue;
                        for (int l = 1; l <= k; l++) {
                            map[i][j] -= l;
                            visited = new int[n][n];
                            dfs(map, visited, p.x, p.y, 1);
                            map[i][j] += l;
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int[][] map, int[][] visited, int r, int c, int cnt) {

        visited[r][c] = cnt;
        if (ans < cnt) {
            ans = cnt;
        }
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (!isValid(nx, ny, map.length) || visited[nx][ny] != 0) {
                continue;
            }
            if (map[nx][ny] >= map[r][c]) {
                // System.out.printf("%d %d\n", map[nx][ny], map[r][c]);
                // System.out.println("check 2");
                continue;
            }
            dfs(map, visited, nx, ny, cnt + 1);
        }
        visited[r][c] = 0;
    }

    static boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
