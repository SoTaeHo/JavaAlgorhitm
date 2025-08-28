
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 31230                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/31230                          #+#        #+#      #+#    */
/*   Solved: 2025/08/28 10:39:57 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int v;
        long weight;

        public Edge(int v, long weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static long[] dijkstra(int start, List<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long[] dist = new long[graph.length];
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.v])
                continue;
            visited[now.v] = true;
            for (Edge next : graph[now.v]) {
                if (dist[next.v] > dist[now.v] + next.weight) {
                    dist[next.v] = dist[now.v] + next.weight;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<Edge>[] li = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            li[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            li[u].add(new Edge(v, weight));
            li[v].add(new Edge(u, weight));
        }

        List<Integer> ans = new ArrayList<>();

        long[] distA = dijkstra(start, li);
        long[] distB = dijkstra(end, li);
        long shortest = distA[end];

        for (int i = 1; i < n + 1; i++) {
            if (distA[i] + distB[i] == shortest) {
                ans.add(i);
            }
        }

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int node : ans) {
            sb.append(node).append(' ');
        }
        System.out.println(sb);
    }
}
