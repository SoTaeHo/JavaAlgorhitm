
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 20183                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/20183                          #+#        #+#      #+#    */
/*   Solved: 2026/02/05 15:16:25 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    static int N, M, A, B;
    static long C;

    static List<Edge>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxW = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
            maxW = Math.max(maxW, w);
        }

        int lo = 0, hi = maxW, mid = (lo + hi) / 2, ans = -1;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (dijkstra(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean dijkstra(int val) {
        long[] d = new long[N + 1];
        Arrays.fill(d, Long.MAX_VALUE);
        d[A] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(value -> value.w));

        pq.add(new Edge(A, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (d[e.v] < e.w) {
                continue;
            }

            for (Edge next : graph[e.v]) {
                if (next.w > val) {
                    continue;
                }
                if (d[next.v] > d[e.v] + next.w && d[e.v] + next.w <= C) {
                    d[next.v] = d[e.v] + next.w;
                    pq.add(new Edge(next.v, d[next.v]));
                }
            }
        }

        return d[B] <= C;
    }
}