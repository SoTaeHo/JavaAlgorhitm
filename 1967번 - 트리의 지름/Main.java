
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1967                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1967                           #+#        #+#      #+#    */
/*   Solved: 2026/02/14 15:15:30 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;

public class Main {

    static class Edge {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int n;
    static List<List<Edge>> graph;
    static int[] dist;

    static int bfs(int start) {
        dist = new int[n + 1];
        boolean visited[] = new boolean[n + 1];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[start] = 0;
        visited[start] = true;
        Queue<Edge> q = new ArrayDeque<>();
        int val = 0;
        int idx = 0;
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge now = q.poll();

            for (Edge e : graph.get(now.v)) {

                if (visited[e.v]) {
                    continue;
                }

                dist[e.v] = dist[now.v] + e.w;
                visited[e.v] = true;
                if (dist[e.v] > val) {
                    idx = e.v;
                    val = dist[e.v];
                }
                q.add(new Edge(e.v, dist[e.v]));
            }
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int first = bfs(1);
        int second = bfs(first);
        System.out.println(dist[second]);
    }
}