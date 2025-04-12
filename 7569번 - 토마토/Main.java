/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7569                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7569                           #+#        #+#      #+#    */
/*   Solved: 2025/04/12 18:17:54 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[n][m][h];
        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < h * n; i++) {
            st = new StringTokenizer(br.readLine());
            int height = i / n;
            for (int j = 0; j < m; j++) {
                map[i % n][j][height] = Integer.parseInt(st.nextToken());
                if (map[i % n][j][height] == 1) {
                    q.offer(new Point(i % n, j, height));
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) {
                    continue;
                }
                if (map[nx][ny][nz] != 0) {
                    continue;
                }
                map[nx][ny][nz] = map[p.x][p.y][p.z] + 1;
                q.offer(new Point(nx, ny, nz));
            }
        }
        // System.out.println("=========================");
        // for (int i = 0; i < h * n; i++) {
        // int height = i / n;
        // for (int j = 0; j < m; j++) {
        // System.out.print(map[i % n][j][height] + " ");
        // }
        // System.out.println();
        // }

        int ans = 0;
        for (int i = 0; i < h * n; i++) {
            int height = i / n;
            for (int j = 0; j < m; j++) {
                if (map[i % n][j][height] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    ans = Math.max(ans, map[i % n][j][height]);
                }
            }
        }
        System.out.println(ans - 1);
    }

    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }
}