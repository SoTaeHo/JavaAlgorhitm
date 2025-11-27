
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2533                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2533                           #+#        #+#      #+#    */
/*   Solved: 2025/11/25 09:24:43 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Integer>[] tree;
    static int[][] dp;

    static void dfs(int cur) {
        if (visited[cur])
            return;
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        for (int e : tree[cur]) {
            if (visited[e])
                continue;
            dfs(e);
            dp[cur][0] += dp[e][1];
            dp[cur][1] += Math.min(dp[e][0], dp[e][1]);
        }
        int x = 10;
        int y = 5;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new List[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}