
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2098                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2098                           #+#        #+#      #+#    */
/*   Solved: 2025/07/31 08:54:48 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] weight;
    static int[][] dp;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, 1));

    }

    static int solve(int cur, int visited) {
        if (visited == (1 << n) - 1) {
            return weight[cur][0] != 0 ? weight[cur][0] : INF;
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;

        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) != 0) {
                continue;
            }

            if (weight[cur][next] == 0) {
                continue;
            }

            dp[cur][visited] = Math.min(dp[cur][visited], weight[cur][next] +
                    solve(next, visited | (1 << next)));
        }

        return dp[cur][visited];
    }
}