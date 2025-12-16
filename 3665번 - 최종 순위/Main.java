
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3665                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3665                           #+#        #+#      #+#    */
/*   Solved: 2025/12/16 14:26:40 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcase = Integer.parseInt(br.readLine());

        for (int T = 0; T < tcase; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] indegree = new int[n + 1];
            boolean[][] graph = new boolean[n + 1][n + 1];

            int[] rank = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int high = rank[i];
                    int low = rank[j];
                    graph[high][low] = true;
                    indegree[low] += 1;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;
                    indegree[a]--;
                    indegree[b]++;
                }
            }
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }

            List<Integer> result = new ArrayList<>();
            boolean ambiguous = false;

            while (!q.isEmpty()) {
                if (q.size() > 1)
                    ambiguous = true;

                int cur = q.poll();
                result.add(cur);

                for (int next = 1; next <= n; next++) {
                    if (graph[cur][next]) {
                        indegree[next]--;
                        if (indegree[next] == 0) {
                            q.add(next);
                        }
                    }
                }
            }

            if (result.size() < n) {
                System.out.println("IMPOSSIBLE");
            } else if (ambiguous) {
                System.out.println("?");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int x : result) {
                    sb.append(x).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
}