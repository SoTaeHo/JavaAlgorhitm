
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14611                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14611                          #+#        #+#      #+#    */
/*   Solved: 2025/08/21 14:13:50 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        long weight;

        public Point(int x, int y, long weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long ans = Long.MAX_VALUE;

        long[][] map = new long[n][m];
        long[][] dist = new long[n][m];
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
                if (i == 0 && map[i][j] != -1) {
                    pq.offer(new Point(i, j, map[i][j] == -2 ? 0 : map[i][j]));
                    dist[i][j] = 0;
                    visited[i][j] = true;
                } else if (j == m - 1 && map[i][j] != -1) {
                    pq.offer(new Point(i, j, map[i][j] == -2 ? 0 : map[i][j]));
                    dist[i][j] = 0;
                    visited[i][j] = true;
                } else {
                    dist[i][j] = Long.MAX_VALUE;
                }
            }
        }

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (p.x == n - 1 || p.y == 0) {
                ans = Math.min(ans, dist[p.x][p.y]);
                // System.out.println(dist[p.x][p.y]);
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == -1) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                long weight = map[nx][ny] == -2 ? 0 : map[nx][ny];
                dist[nx][ny] = Math.min(dist[nx][ny], p.weight + weight);
                visited[nx][ny] = true;
                pq.offer(new Point(nx, ny, weight + p.weight));
            }
        }
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}