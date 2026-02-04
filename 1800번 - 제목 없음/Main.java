
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1800                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1800                           #+#        #+#      #+#    */
/*   Solved: 2026/02/04 16:49:12 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int N, P, K;
    static List<Edge>[] graph;

    static boolean can(int limit) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (Edge e : graph[u]) {
                int cost = dist[u] + (e.w > limit ? 1 : 0);
                if (dist[e.v] > cost) {
                    dist[e.v] = cost;
                    if (e.w > limit) {
                        dq.addLast(e.v);
                    } else {
                        dq.addFirst(e.v);
                    }
                }
            }
        }
        return dist[N] <= K;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        int maxW = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
            maxW = Math.max(maxW, w);
        }

        int lo = 0, hi = maxW, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (can(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}