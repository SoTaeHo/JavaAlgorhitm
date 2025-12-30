
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13911                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13911                          #+#        #+#      #+#    */
/*   Solved: 2025/12/30 14:05:43 by thxogh1       ###          ###   ##.kr    */
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
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int V, E, M, S, x, y;
    static List<Edge>[] graph;

    static int[] dijkstra(int[] dist) {

        int[] d = new int[V + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int e : dist) {
            pq.add(new Edge(e, 0));
            d[e] = 0;
        }

        while (!pq.isEmpty()) {

            Edge now = pq.poll();

            if (now.w > d[now.v]) {
                continue;
            }

            for (Edge next : graph[now.v]) {
                if (next.w + d[now.v] < d[next.v]) {
                    d[next.v] = next.w + d[now.v];
                    pq.offer(new Edge(next.v, d[next.v]));
                }
            }
        }

        return d;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[] macdonald = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            macdonald[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int[] starbucks = new int[S];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < S; i++) {
            starbucks[i] = Integer.parseInt(st.nextToken());
        }

        int[] macdonaldDist = dijkstra(macdonald);
        int[] starbucksDist = dijkstra(starbucks);

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < V + 1; i++) {
            if (macdonaldDist[i] != 0 && starbucksDist[i] != 0 && macdonaldDist[i] <= x && starbucksDist[i] <= y) {
                ans = Math.min(ans, macdonaldDist[i] + starbucksDist[i]);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}