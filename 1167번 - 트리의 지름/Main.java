
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1167                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1167                           #+#        #+#      #+#    */
/*   Solved: 2025/05/05 16:42:48 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static List<List<Node>> li;
    static int ans = 0;
    static boolean[] visited;
    static int temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        li = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            li.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                li.get(root).add(new Node(next, weight));
            }
        }
        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(temp, 0);
        System.out.println(ans);
    }

    static void dfs(int n, int w) {
        if (ans < w) {
            ans = w;
            temp = n;
        }
        visited[n] = true;
        for (int i = 0; i < li.get(n).size(); i++) {
            Node node = li.get(n).get(i);
            if (visited[node.num])
                continue;
            dfs(node.num, w + node.weight);
        }
    }
}