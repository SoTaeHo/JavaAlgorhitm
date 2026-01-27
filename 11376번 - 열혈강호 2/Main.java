/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11376                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11376                          #+#        #+#      #+#    */
/*   Solved: 2026/01/27 13:49:03 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11375                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11375                          #+#        #+#      #+#    */
/*   Solved: 2025/09/05 12:30:05 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static int[] match;
    static boolean[] visited;

    static boolean dfs(int u) {
        for (int job : graph[u]) {
            if (visited[job]) {
                continue;
            }
            visited[job] = true;

            if (match[job] == 0 || dfs(match[job])) {
                match[job] = u;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[2 * N + 1];
        for (int i = 1; i <= 2 * N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int job = Integer.parseInt(st.nextToken());
                graph[i * 2 - 1].add(job);
                graph[i * 2].add(job);
            }
        }

        match = new int[M + 1];

        int ans = 0;
        for (int i = 1; i <= 2 * N; i++) {
            visited = new boolean[M + 1];
            if (dfs(i)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
