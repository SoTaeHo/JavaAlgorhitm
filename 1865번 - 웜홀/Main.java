
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1865                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1865                           #+#        #+#      #+#    */
/*   Solved: 2025/09/08 07:47:16 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Main.Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static boolean bellmanFord(List<Edge> graph, int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (Edge next : graph) {
                if (dist[next.u] != Integer.MAX_VALUE && dist[next.v] > dist[next.u] + next.w) {
                    dist[next.v] = dist[next.u] + next.w;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (Edge next : graph) {
                if (dist[next.u] != Integer.MAX_VALUE && dist[next.v] > dist[next.u] + next.w) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Edge> graph = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.add(new Edge(s, e, t));
                graph.add(new Edge(e, s, t));
            }
            List<Integer> points = new ArrayList<>();
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.add(new Edge(s, e, -t));
                points.add(s);
            }
            boolean isCycle = false;
            for (int i : points) {
                if (bellmanFord(graph, n, i)) {
                    System.out.println("YES");
                    isCycle = true;
                    break;
                }
            }
            if (!isCycle) {
                System.out.println("NO");
            }
        }
    }
}