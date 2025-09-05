/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 9376                              :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/9376                           #+#        #+#      #+#    */
 /*   Solved: 2025/09/05 19:20:27 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int h, w;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] bfs(Point start) {
        int[][] dist = new int[h + 2][w + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<Point> dq = new ArrayDeque<>();
        dq.add(start);
        dist[start.x][start.y] = 0;

        while (!dq.isEmpty()) {
            Point now = dq.poll();
            int x = now.x, y = now.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx > h + 1 || ny > w + 1) {
                    continue;
                }
                if (graph[nx][ny] == -1) {
                    continue;
                }
                int cost = dist[x][y];
                if (graph[nx][ny] == 2) {
                    cost++;
                }
                if (dist[nx][ny] > cost) {
                    dist[nx][ny] = cost;
                    if (graph[nx][ny] == 2) {
                        dq.addLast(new Point(nx, ny));
                    } else {
                        dq.addFirst(new Point(nx, ny));
                    }
                }
            }
        }
        return dist;
    }

    static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        graph = new int[h + 2][w + 2];
        for (int[] row : graph) {
            Arrays.fill(row, 0);
        }
        List<Point> prisoners = new ArrayList<>();

        for (int i = 1; i <= h; i++) {
            String str = br.readLine();
            for (int j = 1; j <= w; j++) {
                char c = str.charAt(j - 1);
                if (c == '*') {
                    graph[i][j] = -1;
                } else if (c == '#') {
                    graph[i][j] = 2;
                } else if (c == '$') {
                    prisoners.add(new Point(i, j));
                    graph[i][j] = 0;
                }
            }
        }

        int[][] distOut = bfs(new Point(0, 0));
        int[][] distA = bfs(prisoners.get(0));
        int[][] distB = bfs(prisoners.get(1));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= h + 1; i++) {
            for (int j = 0; j <= w + 1; j++) {
                if (graph[i][j] == -1) {
                    continue;
                }
                if (distOut[i][j] == Integer.MAX_VALUE
                        || distA[i][j] == Integer.MAX_VALUE
                        || distB[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int cost = distOut[i][j] + distA[i][j] + distB[i][j];
                if (graph[i][j] == 2) {
                    cost -= 2;
                }
                ans = Math.min(ans, cost);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            solve();
        }
    }
}
