
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14938                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14938                          #+#        #+#      #+#    */
/*   Solved: 2025/08/25 16:32:36 by thxogh1       ###          ###   ##.kr    */
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
        int weight;

        public Edge(int v, int weight) {
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
        int r = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        @SuppressWarnings("unchecked")
        List<Edge>[] li = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            li[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            li[u].add(new Edge(v, weight));
            li[v].add(new Edge(u, weight));
        }

        for (int i = 1; i < n + 1; i++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            pq.offer(new Edge(i, 0));

            while (!pq.isEmpty()) {

                Edge now = pq.poll();

                if (now.weight > dist[now.v])
                    continue;

                for (Edge next : li[now.v]) {
                    if (dist[next.v] > dist[now.v] + next.weight && dist[now.v] + next.weight <= m) {
                        dist[next.v] = dist[now.v] + next.weight;
                        pq.offer(new Edge(next.v, dist[next.v]));
                    }
                }
            }
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    sum += item[j];
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}