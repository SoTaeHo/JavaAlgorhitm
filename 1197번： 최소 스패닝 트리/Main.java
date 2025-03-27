
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1197                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1197                           #+#        #+#      #+#    */
/*   Solved: 2025/03/27 10:27:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int ans = 0;
        List<List<Edge>> li = new ArrayList<>();
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i <= v; i++) {
            li.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            li.get(a).add(new Edge(b, c));
            li.get(b).add(new Edge(a, c));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();

        for (int i = 0; i < li.get(1).size(); i++) {
            q.offer(li.get(1).get(i));
        }

        visited[1] = true;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            if (visited[edge.dest]) {
                continue;
            }

            ans += edge.weight;
            visited[edge.dest] = true;

            for (Edge temp : li.get(edge.dest)) {
                if (!visited[temp.dest]) {
                    q.offer(temp);
                }
            }
        }
        System.out.println(ans);
    }

    static class Edge implements Comparable<Edge> {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }
}