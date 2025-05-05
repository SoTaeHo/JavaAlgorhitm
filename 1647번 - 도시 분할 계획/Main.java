
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1647                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1647                           #+#        #+#      #+#    */
/*   Solved: 2025/05/05 19:44:42 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int e;
        int w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        List<List<Edge>> li = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            li.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            li.get(a).add(new Edge(b, c));
            li.get(b).add(new Edge(a, c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        for (int i = 0; i < li.get(1).size(); i++) {
            pq.offer(li.get(1).get(i));
        }
        visited[1] = true;
        int ans = 0;
        int maxCost = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.e]) {
                continue;
            }

            visited[edge.e] = true;
            ans += edge.w;
            maxCost = Math.max(maxCost, edge.w);

            for (int i = 0; i < li.get(edge.e).size(); i++) {
                if (visited[li.get(edge.e).get(i).e])
                    continue;
                pq.offer(li.get(edge.e).get(i));
            }
        }

        System.out.println(ans - maxCost);
    }
}