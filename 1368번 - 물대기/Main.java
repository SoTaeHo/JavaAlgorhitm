
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1368                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1368                           #+#        #+#      #+#    */
/*   Solved: 2025/08/12 16:24:00 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] rank;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootY]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Edge> li = new ArrayList<>();
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            li.add(new Edge(i, 0, Integer.parseInt(br.readLine())));
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    st.nextToken();
                    continue;
                } else
                    li.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        Collections.sort(li);

        int ans = 0;
        for (Edge e : li) {
            if (find(e.x) != find(e.y)) {
                union(e.x, e.y);
                ans += e.weight;
            }
        }
        System.out.println(ans);
    }
}