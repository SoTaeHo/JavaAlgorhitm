
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1854                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1854                           #+#        #+#      #+#    */
/*   Solved: 2025/09/01 11:58:28 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v;
        int weight;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
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

            graph[u].add(new Edge(v, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = new PriorityQueue<>(k, Comparator.reverseOrder());
        }
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            // if (dist[now.v].size() >= k) {
            // continue;
            // }

            for (Edge e : graph[now.v]) {
                if (dist[e.v].size() < k) {
                    dist[e.v].offer(now.weight + e.weight);
                    pq.offer(new Edge(e.v, now.weight + e.weight));
                } else if (dist[e.v].peek() > now.weight + e.weight) {
                    dist[e.v].poll();
                    dist[e.v].offer(now.weight + e.weight);
                    pq.offer(new Edge(e.v, now.weight + e.weight));
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (dist[i].size() < k) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i].peek());
            }
        }
    }
}