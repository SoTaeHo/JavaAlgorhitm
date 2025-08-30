
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13308                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13308                          #+#        #+#      #+#    */
/*   Solved: 2025/08/30 15:32:49 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static class Edge {
        int v;
        int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        long cost;
        int node;
        int minOil;

        public State(long cost, int node, int minOil) {
            this.cost = cost;
            this.node = node;
            this.minOil = minOil;
        }

        @Override
        public int compareTo(Main.State o) {
            return Long.compare(this.cost, o.cost);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] oil = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        @SuppressWarnings("unchecked")
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
            graph[v].add(new Edge(u, weight));
        }

        long[][] dp = new long[n + 1][2501];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 1, oil[1]));
        dp[1][oil[1]] = 0;

        while (!pq.isEmpty()) {
            State now = pq.poll();
            if (now.node == n) {
                System.out.println(now.cost);
                return;
            }

            if (dp[now.node][now.minOil] < now.cost)
                continue;

            for (Edge e : graph[now.node]) {
                int next = e.v;
                int newMinOil = Math.min(oil[next], now.minOil);
                long newCost = now.cost + (long) now.minOil * e.weight;
                if (dp[next][newMinOil] > newCost) {
                    dp[next][newMinOil] = newCost;
                    pq.add(new State(newCost, next, newMinOil));
                }
            }

        }
    }
}