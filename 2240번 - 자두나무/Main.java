
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2240                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2240                           #+#        #+#      #+#    */
/*   Solved: 2026/01/03 14:50:05 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] tree = new int[T + 1];

        for (int i = 1; i < T + 1; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[T + 1][W + 1][2];

        dp[0][0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < T + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j][0] = dp[i - 1][j][0];
                if (j > 0 && j % 2 == 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1]);
                }

                dp[i][j][1] = dp[i - 1][j][1];
                if (j > 0 && j % 2 == 1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][0]);
                }

                if (tree[i] == 1)
                    dp[i][j][0]++;
                if (tree[i] == 2)
                    dp[i][j][1]++;
            }
        }

        int ans = 0;

        for (int i = 0; i < W + 1; i++) {
            ans = Math.max(ans, Math.max(dp[T][i][0], dp[T][i][1]));
        }
        System.out.println(ans);
    }
}