
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4963                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4963                           #+#        #+#      #+#    */
/*   Solved: 2025/09/15 08:47:49 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] graph = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[][] visited = new boolean[h][w];
            Queue<Point> q = new ArrayDeque<>();
            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        q.offer(new Point(i, j));
                        ans += 1;
                        visited[i][j] = true;

                        while (!q.isEmpty()) {
                            Point now = q.poll();

                            for (int k = 0; k < 8; k++) {
                                int nx = now.x + dx[k];
                                int ny = now.y + dy[k];

                                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                                    continue;
                                }
                                if (visited[nx][ny]) {
                                    continue;
                                }
                                if (graph[nx][ny] == 0) {
                                    continue;
                                }
                                visited[nx][ny] = true;
                                q.offer(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}