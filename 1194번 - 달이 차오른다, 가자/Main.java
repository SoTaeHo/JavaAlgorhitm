
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1194                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1194                           #+#        #+#      #+#    */
/*   Solved: 2025/04/08 12:13:53 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][][] map = new char[n][m][64];
        int[][][] visited = new int[n][m][64];
        List<Point> exit = new ArrayList<>();
        Point start = null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                for (int k = 0; k < 64; k++) {
                    if ((k & (1 << c - 65)) > 0 && 'A' <= c && c <= 'F') {
                        map[i][j][k] = '.';
                    } else {
                        map[i][j][k] = c;
                    }
                }
                if (map[i][j][0] == '0') {
                    start = new Point(i, j, 0);
                }
                if (map[i][j][0] == '1') {
                    exit.add(new Point(i, j, 0));
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(map[i][j][0]);
        // }
        // System.out.println();
        // }
        // 1 0 0 0 0 0
        // 32 16 8 4 2 1
        Queue<Point> q = new ArrayDeque<>();

        q.offer(start);
        visited[start.x][start.y][start.level] = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!isValid(nx, ny, n, m) || visited[nx][ny][p.level] != 0 || map[nx][ny][p.level] == '#'
                        || isWall(map[nx][ny][p.level])) {
                    continue;
                }
                visited[nx][ny][p.level] = visited[p.x][p.y][p.level] + 1;
                q.offer(new Point(nx, ny, p.level));
                if ('a' <= map[nx][ny][p.level] && map[nx][ny][p.level] <= 'f'
                        && !((p.level & (1 << (map[nx][ny][p.level] - 'a'))) > 0)) {
                    int key = p.level + (1 << (map[nx][ny][p.level] - 'a'));
                    visited[nx][ny][key] = visited[p.x][p.y][p.level] + 1;
                    q.offer(new Point(nx, ny, key));
                }

            }
        }

        int ans = Integer.MAX_VALUE;
        for (Point p : exit) {
            for (int i = 0; i < 64; i++) {
                if (visited[p.x][p.y][i] != 0) {
                    ans = Math.min(ans, visited[p.x][p.y][i]);
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(visited[i][j][63]);
        // }
        // System.out.println();
        // }
        System.out.println(ans != Integer.MAX_VALUE ? ans - 1 : -1);
    }

    static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    static boolean isWall(char c) {
        return 'A' <= c && c <= 'F';
    }

    static class Point {
        int x;
        int y;
        int level;

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}

// 000000 += (1 << 0,1,2,3,4,5)
