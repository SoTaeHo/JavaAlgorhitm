
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1504                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1504                           #+#        #+#      #+#    */
/*   Solved: 2025/05/02 19:10:39 by thxogh1       ###          ###   ##.kr    */
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
    static int INF = 200000 * 1000 + 1;
    static List<Edge>[] li;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        li = (List<Edge>[]) new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            li[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            li[s].add(new Edge(e, w));
            li[e].add(new Edge(s, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = dijkstra(1, v1, n);
        ans1 += dijkstra(v1, v2, n);
        ans1 += dijkstra(v2, n, n);

        int ans2 = dijkstra(1, v2, n);
        ans2 += dijkstra(v2, v1, n);
        ans2 += dijkstra(v1, n, n);
        if (ans1 >= INF && ans2 >= INF) {
            System.out.println(-1);
        } else
            System.out.println(Math.min(ans1, ans2));
    }

    static int dijkstra(int start, int end, int n) {
        int[] d = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(d, INF);
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> (o1.w - o2.w));

        d[start] = 0;
        q.offer(new Edge(start, 0));
        while (!q.isEmpty()) {
            Edge edge = q.poll();

            if (visited[edge.e]) {
                continue;
            }
            visited[edge.e] = true;

            for (int i = 0; i < li[edge.e].size(); i++) {
                Edge next = li[edge.e].get(i);
                if (!visited[next.e] && d[next.e] > d[edge.e] + next.w) {
                    d[next.e] = d[edge.e] + next.w;
                    q.offer(new Edge(next.e, d[next.e]));
                }
            }
        }
        return d[end];
    }

    static class Edge {
        int e;
        int w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}