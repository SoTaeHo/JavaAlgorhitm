
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5719                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5719                           #+#        #+#      #+#    */
/*   Solved: 2025/09/02 19:26:02 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int v;
        int weight;
        boolean removed;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
            this.removed = false;
        }
    }

    static int n, m, s, d;
    static List<Edge>[] graph;
    static List<Integer>[] parent;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0)
                break;

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            graph = new List[n];
            parent = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                parent[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[u].add(new Edge(v, w));
            }

            dijkstra();

            removeEdges();

            int ans = dijkstra();
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
    }

    static int dijkstra() {
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.v;
            int cost = cur.weight;

            if (cost > dist[u])
                continue;

            for (Edge e : graph[u]) {
                if (e.removed)
                    continue;
                int v = e.v;
                int newCost = cost + e.weight;

                if (dist[v] > newCost) {
                    dist[v] = newCost;
                    pq.offer(new Edge(v, newCost));
                    if (parent != null) {
                        parent[v].clear();
                        parent[v].add(u);
                    }
                } else if (dist[v] == newCost && parent != null) {
                    parent[v].add(u);
                }
            }
        }

        return dist[d];
    }

    static void removeEdges() {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(d);
        visited[d] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int prev : parent[cur]) {
                for (Edge e : graph[prev]) {
                    if (e.v == cur)
                        e.removed = true;
                }
                if (!visited[prev]) {
                    visited[prev] = true;
                    q.offer(prev);
                }
            }
        }
    }

}