
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1162                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1162                           #+#        #+#      #+#    */
/*   Solved: 2025/09/01 20:18:31 by thxogh1       ###          ###   ##.kr    */
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

    static class Edge implements Comparable<Edge> {
        int v;
        long weight;
        int cnt;

        Edge(int v, long weight, int cnt) {
            this.v = v;
            this.weight = weight;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Main.Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, weight, 0));
            graph[v].add(new Edge(u, weight, 0));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        long[][] dist = new long[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        dist[1][0] = 0;

        pq.add(new Edge(1, 0, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.weight > dist[now.v][now.cnt]) {
                continue;
            }

            for (Edge next : graph[now.v]) {
                if (dist[next.v][now.cnt] > dist[now.v][now.cnt] + next.weight) {
                    dist[next.v][now.cnt] = dist[now.v][now.cnt] + next.weight;
                    pq.offer(new Edge(next.v, dist[next.v][now.cnt], now.cnt));
                }
                if (now.cnt < k && dist[next.v][now.cnt + 1] > dist[now.v][now.cnt]) {
                    dist[next.v][now.cnt + 1] = dist[now.v][now.cnt];
                    pq.offer(new Edge(next.v, dist[now.v][now.cnt], now.cnt + 1));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            ans = Math.min(ans, dist[n][i]);
        }
        System.out.println(ans);
    }
}