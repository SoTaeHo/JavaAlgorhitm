
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 6087                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/6087                           #+#        #+#      #+#    */
/*   Solved: 2026/04/07 22:27:43 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int W, H;
    static char[][] graph;
    static int[][][] dist;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new char[H][W];
        dist = new int[H][W][4];

        List<int[]> cs = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                graph[i][j] = str.charAt(j);
                if (graph[i][j] == 'C')
                    cs.add(new int[] { i, j });
                for (int d = 0; d < 4; d++)
                    dist[i][j][d] = INF;
            }
        }

        int sy = cs.get(0)[0], sx = cs.get(0)[1];
        int ey = cs.get(1)[0], ex = cs.get(1)[1];

        // 0-1 BFS with Deque
        Deque<int[]> dq = new ArrayDeque<>();

        // 시작점: 4방향 모두 비용 0으로 출발
        for (int d = 0; d < 4; d++) {
            dist[sy][sx][d] = 0;
            dq.addFirst(new int[] { sy, sx, d });
        }

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int y = cur[0], x = cur[1], d = cur[2];

            if (dist[y][x][d] < cur.length - 3)
                continue;

            for (int nd = 0; nd < 4; nd++) {
                int ny = y + dy[nd];
                int nx = x + dx[nd];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W)
                    continue;
                if (graph[ny][nx] == '*')
                    continue;

                int cost = (d == nd) ? 0 : 1;

                if (dist[y][x][d] + cost < dist[ny][nx][nd]) {
                    dist[ny][nx][nd] = dist[y][x][d] + cost;
                    if (cost == 0)
                        dq.addFirst(new int[] { ny, nx, nd });
                    else
                        dq.addLast(new int[] { ny, nx, nd });
                }
            }
        }

        int ans = INF;
        for (int d = 0; d < 4; d++) {
            ans = Math.min(ans, dist[ey][ex][d]);
        }

        System.out.println(ans);
    }
}