
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Main.Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int dijkstra(PriorityQueue<Edge> pq, int[][] graph, int[][] dist, int w, int h) {

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.weight > dist[now.x][now.y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= h || nx < 0 || ny >= w || ny < 0) {
                    continue;
                }
                if (graph[nx][ny] == -1) {
                    continue;
                }

                // 지나갈 수 있는 길인 경우
                if (graph[nx][ny] == 0 && dist[nx][ny] > now.weight) {
                    dist[nx][ny] = now.weight;
                    pq.offer(new Edge(nx, ny, now.weight));
                }
                // 열 수 있는 벽인 경우
                else if (graph[nx][ny] == 2 && dist[nx][ny] > now.weight + 1) {
                    dist[nx][ny] = now.weight + 1;
                    graph[nx][ny] = 0;
                    pq.offer(new Edge(nx, ny, now.weight + 1));
                }
                // 죄수 위치에 도착한 경우
                else if (graph[nx][ny] == 3 && dist[nx][ny] > now.weight) {
                    dist[nx][ny] = now.weight;
                    graph[nx][ny] = 0;
                    return dist[nx][ny];
                }
            }
        }
        return 0;
    }

    static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] graph = new int[h][w];
        int[][] dist = new int[h][w];

        for (int i = 0; i < h; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                if (str.charAt(j) == '*') {
                    graph[i][j] = -1;
                } else if (str.charAt(j) == '#') {
                    graph[i][j] = 2;
                    if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        pq.offer(new Edge(i, j, 1));
                        dist[i][j] = 1;
                    }
                } else if (str.charAt(j) == '$') {
                    graph[i][j] = 3;
                } else if (str.charAt(j) == '.') {
                    if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        pq.offer(new Edge(i, j, 0));
                        dist[i][j] = 0;
                    }
                }
            }
        }
        int first = dijkstra(pq, graph, dist, w, h);
        pq.clear();
        for (int i = 0; i < h; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == '#') {
                    if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        pq.offer(new Edge(i, j, 1));
                        dist[i][j] = 1;
                    }
                } else if (graph[i][j] == '.') {
                    if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        pq.offer(new Edge(i, j, 0));
                        dist[i][j] = 0;
                    }
                }
            }
        }
        int second = dijkstra(pq, graph, dist, w, h);
        System.out.println("first : " + first);
        System.out.println("second : " + second);
        System.out.println(first + second);
        // int ans = Math.max(dist[ansX.get(0)][ansY.get(0)],
        // dist[ansX.get(1)][ansY.get(1)]);
        // System.out.println("first : " + dist[ansX.get(0)][ansY.get(0)]);
        // System.out.println("second : " + dist[ansX.get(1)][ansY.get(1)]);

        // System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            solve();
        
    }
}