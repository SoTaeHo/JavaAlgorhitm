/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 14946                             :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/14946                          #+#        #+#      #+#    */
 /*   Solved: 2025/12/24 19:12:10 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int V, Q, K;
    static List<Integer>[] tree;
    static int[][] cost;
    static long[][][] dp;

    static boolean canConnect(int a, int b) {
        // G-G 금지
        if (a == 1 && b == 1) {
            return false;
        }

        // B가 있으면 상대는 반드시 G
        if (a == 2 && b != 1) {
            return false;
        }

        if (b == 2 && a != 1) {
            return false;
        }

        return true;
    }

    static void dfs(int u, int parent) {
        // 초기값
        for (int c = 0; c < 3; c++) {
            int m = cost[u][c] % K;
            dp[u][c][m] = 1;
        }

        for (int v : tree[u]) {
            if (v == parent) {
                continue;
            }
            dfs(v, u);

            long[][] newDp = new long[3][K];

            for (int cu = 0; cu < 3; cu++) {
                for (int mu = 0; mu < K; mu++) {
                    if (dp[u][cu][mu] == 0) {
                        continue;
                    }

                    for (int cv = 0; cv < 3; cv++) {
                        if (!canConnect(cu, cv)) {
                            continue;
                        }

                        for (int mv = 0; mv < K; mv++) {
                            if (dp[v][cv][mv] == 0) {
                                continue;
                            }

                            int nm = (mu + mv) % K;
                            newDp[cu][nm] = (newDp[cu][nm]
                                    + dp[u][cu][mu] * dp[v][cv][mv]) % Q;
                        }
                    }
                }
            }
            dp[u] = newDp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        cost = new int[V + 1][3];
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp = new long[V + 1][3][K];
        dfs(1, 0);

        long ans = 0;
        for (int c = 0; c < 3; c++) {
            ans = (ans + dp[1][c][0]) % Q;
        }

        System.out.println(ans);
    }
}
