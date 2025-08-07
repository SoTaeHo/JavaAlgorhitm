
// /* ************************************************************************** */
// /*                                                                            */
// /*                                                      :::    :::    :::     */
// /*   Problem Number: 1325                              :+:    :+:      :+:    */
// /*                                                    +:+    +:+        +:+   */
// /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
// /*                                                  +#+      +#+        +#+   */
// /*   https://boj.kr/1325                           #+#        #+#      #+#    */
// /*   Solved: 2025/08/07 08:57:47 by thxogh1       ###          ###   ##.kr    */
// /*                                                                            */
// /* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> adj;
    static int[] hackCounts;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
        }

        hackCounts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int maxCount = 0;
        for (int i = 1; i <= N; i++) {
            if (hackCounts[i] > maxCount) {
                maxCount = hackCounts[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackCounts[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int node) {
        visited[node] = true;
        hackCounts[node]++;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}