
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2206                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2206                           #+#        #+#      #+#    */
/*   Solved: 2025/05/06 20:35:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Point {
        int x, y;
        boolean crash = false;

        Point(int x, int y, boolean crash) {
            this.x = x;
            this.y = y;
            this.crash = crash;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][][] visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Point> q = new ArrayDeque<>();

        q.offer(new Point(0, 0, false));
        visited[0][0][0] = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (p.crash) {
                    if (visited[nx][ny][1] != 0 || visited[nx][ny][0] != 0) {
                        continue;
                    }
                    if (map[nx][ny] == 1) {
                        continue;
                    }
                    visited[nx][ny][1] = visited[p.x][p.y][1] + 1;
                    q.offer(new Point(nx, ny, true));
                } else {
                    if (visited[nx][ny][0] != 0) {
                        continue;
                    }
                    if (map[nx][ny] == 1) {
                        visited[nx][ny][1] = visited[p.x][p.y][0] + 1;
                        q.offer(new Point(nx, ny, true));
                    } else {
                        visited[nx][ny][0] = visited[p.x][p.y][0] + 1;
                        q.offer(new Point(nx, ny, false));
                    }
                }
            }
        }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.printf("%d ", visited[i][j][1]);
        // }
        // System.out.println();
        // }
        if (visited[n - 1][m - 1][0] == 0 && visited[n - 1][m - 1][1] == 0) {
            System.out.println(-1);
        } else if (visited[n - 1][m - 1][0] == 0) {
            System.out.println(visited[n - 1][m - 1][1]);
        } else if (visited[n - 1][m - 1][1] == 0) {
            System.out.println(visited[n - 1][m - 1][0]);
        } else {
            int ans = Math.min(visited[n - 1][m - 1][0], visited[n - 1][m - 1][1]);
            System.out.println(ans);
        }
    }
}