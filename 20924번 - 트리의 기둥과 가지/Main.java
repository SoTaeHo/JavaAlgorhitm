/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 20924                             :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/20924                          #+#        #+#      #+#    */
 /*   Solved: 2026/02/16 18:34:35 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, R;
    static List<List<Edge>> graph;
    static int pillar = 0;
    static int branch = 0;
    static boolean[] visited;

    static class Edge {

        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        branch = Math.max(branch, dist);

        for (Edge e : graph.get(node)) {
            if (!visited[e.v]) {
                dfs(e.v, dist + e.w);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, d));
            graph.get(b).add(new Edge(a, d));
        }

        int cur = R;
        int parent = -1;

        while (true) {
            int cnt = 0;
            Edge next = null;

            for (Edge e : graph.get(cur)) {
                if (e.v != parent) {
                    cnt++;
                    next = e;
                }
            }

            if (cnt != 1) {
                break;
            }

            pillar += next.w;
            parent = cur;
            cur = next.v;
        }

        visited = new boolean[N + 1];
        if (parent != -1) {
            visited[parent] = true;
        }
        if (graph.get(cur).size() == 1 && cur != R) {
            branch = 0;
        } else {
            dfs(cur, 0);
        }
        System.out.println(pillar + " " + branch);
    }
}
